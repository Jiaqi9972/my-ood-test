package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;

public class SizeSearchCriteria implements SearchCriteria {

    private long maxSize;
    private long minSize;

    public SizeSearchCriteria(long maxSize, long minSize) {
        this.maxSize = maxSize;
        this.minSize = minSize;
    }

    @Override
    public boolean match(FileSystemElement fileSystemElement){
        return fileSystemElement.getSize() >= maxSize && fileSystemElement.getSize() <= minSize;
    }
}
