package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.entry.File;

public class SizeSearch implements SearchCriteria{

    private final int maxSize;
    private final int minSize;

    public SizeSearch(int maxSize, int minSize) {
        this.maxSize = maxSize;
        this.minSize = minSize;
    }

    @Override
    public boolean matches(File file) {
        return file.getSize() <= maxSize && file.getSize() >= minSize;
    }
}
