package filesearch.search;

import filesearch.entry.File;

public class ExtensionSearch implements SearchCriteria{

    private final String extension;
    public ExtensionSearch(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean matches(File file) {
        return extension.equals(file.getExtension());
    }
}
