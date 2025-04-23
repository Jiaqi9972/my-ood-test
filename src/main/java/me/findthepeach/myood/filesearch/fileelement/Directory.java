package me.findthepeach.myood.filesearch.fileelement;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemElement{
    private List<FileSystemElement> children;

    public Directory(String name, FileSystemElement parent){
        super(name, parent);
        children = new ArrayList<>();
    }

    public Directory(String name){
        super(name, null);
        children = new ArrayList<>();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemElement child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public List<FileSystemElement> getChildren(){
        return this.children;
    }

    public void addChild(FileSystemElement child){
        children.add(child);
        updateLastModified();
    }
}
