package me.findthepeach.myood.filesearch.entry;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    public List<Entry> children;

    public Directory(String name){
        super(name);;
        this.children = new ArrayList<>();
        System.out.println("Directory created: " + name);
    }

    @Override
    public boolean isDirectory(){
        return true;
    }

    public void addChild(Entry entry){
        children.add(entry);
        System.out.println("Entry " + entry.getName() + " was added in" + getName());
    }

    public List<Entry> getChildren(){
        return children;
    }
}
