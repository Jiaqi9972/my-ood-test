package lrucache;

public class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
