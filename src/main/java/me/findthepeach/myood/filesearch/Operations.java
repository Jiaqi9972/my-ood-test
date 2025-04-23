package me.findthepeach.myood.filesearch;

import me.findthepeach.myood.filesearch.fileelement.Directory;
import me.findthepeach.myood.filesearch.fileelement.File;
import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;
import me.findthepeach.myood.filesearch.search.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    public Directory createRoot(String name){
        return new Directory(name);
    }

    public Directory createDirectory(String name, Directory parent){
        Directory directory = new Directory(name, parent);
        parent.addChild(directory);
        return directory;
    }

    public File createFile(String name, Directory parent, long size, String extension){
        File file =  new File(name, parent, size, extension);
        parent.addChild(file);
        return file;
    }

    public List<FileSystemElement> search(Directory directory, SearchCriteria searchCriteria){
        List<FileSystemElement> results = new ArrayList<>();
        searchRecursive(directory, searchCriteria, results);
        return results;
    }

    public List<FileSystemElement> complexSearch(Directory directory, List<SearchCriteria> searchCriteria){
        List<FileSystemElement> results = new ArrayList<>();
        complexSearchRecursive(directory, searchCriteria, results);
        return results;
    }

    public void searchRecursive(Directory directory, SearchCriteria searchCriteria, List<FileSystemElement> results){
        for(FileSystemElement element : directory.getChildren()){
            if(searchCriteria.match(element)){
                results.add(element);
            }
            if(element.isDirectory()){
                searchRecursive((Directory) element, searchCriteria, results);
            }
        }
    }

    public void complexSearchRecursive(Directory directory, List<SearchCriteria> searchCriteria, List<FileSystemElement> results){
        for(FileSystemElement element : directory.getChildren()){
            if(matchesAllCriteria(element, searchCriteria)){
                results.add(element);
            }
            if(element.isDirectory()){
                complexSearchRecursive((Directory) element, searchCriteria, results);
            }
        }
    }

    private boolean matchesAllCriteria(FileSystemElement element, List<SearchCriteria> criteriaList) {
        for (SearchCriteria criteria : criteriaList) {
            if (!criteria.match(element)) {
                return false;
            }
        }
        return true;
    }

}
