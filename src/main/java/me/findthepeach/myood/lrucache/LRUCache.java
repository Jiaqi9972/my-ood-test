package me.findthepeach.myood.lrucache;

import java.util.HashMap;
import java.util.Map;

/*
* The LRU cache should support the following operations:
put(key, value): Insert a key-value pair into the cache.
* If the cache is at capacity, remove the least recently used item before inserting the new item.
get(key): Get the value associated with the given key.
* If the key exists in the cache, move it to the front of the cache (most recently used) and return its value.
* If the key does not exist, return -1.
The cache should have a fixed capacity, specified during initialization.
The cache should be thread-safe, allowing concurrent access from multiple threads.
The cache should be efficient in terms of time complexity for both put and get operations, ideally O(1).
* */

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized void put(K key, V value) {
        if(!cache.containsKey(key)){
            Node<K, V> node = new Node<>(key, value);
            //check capacity
            if(cache.size() == capacity){
                cache.remove(tail.prev.key);
                removeLast();
            }
            //move node to head
            cache.put(key, node);
            addToHead(node);

        }else{
            if(cache.get(key).value != value){
                // update value
                cache.get(key).setValue(value);
            }
            //move node to head
            removeNode(cache.get(key));
            addToHead(cache.get(key));
        }
    }

    public synchronized V get(K key) {
        if(cache.containsKey(key)){
            // move node to head
            removeNode(cache.get(key));
            addToHead(cache.get(key));
            return cache.get(key).value;
        }else{
            return null;
        }
    }

    private synchronized void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private synchronized void addToHead(Node<K, V> node) {
        node.setNext(head.next);
        head.next.prev = node;
        head.next = node;
        node.setPrev(head);
    }

    private synchronized void removeLast() {
        removeNode(tail.prev);
    }
}
