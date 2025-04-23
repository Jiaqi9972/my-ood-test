package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;

import java.util.Date;

public class DateSearchCriteria implements SearchCriteria{
    private Date startDate;
    private Date endDate;
    public DateSearchCriteria(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean match(FileSystemElement fileSystemElement){
        Date lastModifiedDate = fileSystemElement.getLastModified();
        return lastModifiedDate.after(startDate) && lastModifiedDate.before(endDate);
    }
}
