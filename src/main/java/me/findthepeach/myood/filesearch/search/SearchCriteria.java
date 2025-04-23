package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;

public interface SearchCriteria {
    boolean match(FileSystemElement fileSystemElement);
}
