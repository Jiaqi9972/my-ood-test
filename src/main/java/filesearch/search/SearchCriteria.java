package filesearch.search;

import filesearch.entry.File;

public interface SearchCriteria {
    boolean matches(File file);
}
