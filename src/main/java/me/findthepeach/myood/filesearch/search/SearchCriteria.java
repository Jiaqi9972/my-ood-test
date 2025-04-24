package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.entry.File;

public interface SearchCriteria {
    boolean matches(File file);
}
