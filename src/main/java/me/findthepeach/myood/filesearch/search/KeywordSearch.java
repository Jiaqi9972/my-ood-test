package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.entry.File;

public class KeywordSearch implements SearchCriteria{

    private final String keyword;
    public KeywordSearch(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(File entry){
        return entry.getName().contains(keyword);
    }
}
