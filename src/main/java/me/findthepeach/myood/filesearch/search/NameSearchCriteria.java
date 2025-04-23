package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;

public class NameSearchCriteria implements SearchCriteria{

    private String namePattern;

    public NameSearchCriteria(String namePattern) {
        this.namePattern = namePattern;
    }

    @Override
    public boolean match(FileSystemElement fileSystemElement) {
        return fileSystemElement.getName().contains(namePattern);
    }
}
