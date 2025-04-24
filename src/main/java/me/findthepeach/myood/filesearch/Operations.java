package me.findthepeach.myood.filesearch;

import me.findthepeach.myood.filesearch.entry.Directory;
import me.findthepeach.myood.filesearch.entry.Entry;
import me.findthepeach.myood.filesearch.entry.File;
import me.findthepeach.myood.filesearch.search.CompositeSearch;
import me.findthepeach.myood.filesearch.search.SearchCriteria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operations {
    public File createFile(String fileName, String extension, long size){
        return new File(fileName, extension, size);
    }

    public Directory createDirectory(String directoryName){
        return new Directory(directoryName);
    }

    public void addInDirectory(Directory directory, Entry entry){
        directory.addChild(entry);
    }

    public List<File> searchInDirectory(Directory directory, CompositeSearch compositeSearch){
        List<File> res = new ArrayList<>();
        Queue<Directory> queue = new LinkedList<>();
        queue.add(directory);
        while(!queue.isEmpty()){
            Directory current = queue.poll();;
            for(Entry entry : current.getChildren()){
                if(entry.isDirectory()){
                    queue.offer((Directory) entry);
                }else{
                    if(compositeSearch.matches((File) entry)){
                        res.add((File) entry);
                    }
                }

            }
        }
        return res;
    }

    public List<File> searchInDirectory(Directory directory, SearchCriteria searchCriteria){
        List<File> res = new ArrayList<>();
        Queue<Directory> queue = new LinkedList<>();
        queue.add(directory);
        while(!queue.isEmpty()){
            Directory current = queue.poll();
            for(Entry entry : current.getChildren()){
                if(entry.isDirectory()){
                    queue.offer((Directory) entry);
                }else {
                    if(searchCriteria.matches((File) entry)){
                        res.add((File) entry);
                    }
                }
            }
        }
        return res;
    }


}
