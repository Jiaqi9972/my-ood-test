package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.fileelement.File;
import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;

public class ExtensionSearchCriteria implements SearchCriteria{
    private String extension;

    public ExtensionSearchCriteria(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean match(FileSystemElement fileSystemElement) {
        if(!fileSystemElement.isDirectory()){
            File file = (File) fileSystemElement;
            return extension.equals(file.getExtension());
        }
        return false;
    }
}
