package me.findthepeach.myood.filesearch.fileelement;

import java.util.Date;

public abstract class FileSystemElement {
    private String name;
    private Date lastModified;
    private Date created;
    private FileSystemElement parent;

    public FileSystemElement(String name, FileSystemElement parent) {
        this.name = name;
        this.parent = parent;
        this.created = new Date();
        this.lastModified = new Date();
    }

    public abstract boolean isDirectory();
    public abstract long getSize();

    public String getPath(){
        if (parent == null) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }

    public String getName() {
        return name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void updateLastModified() {
        this.lastModified = new Date();
        if (parent != null) {
            parent.updateLastModified();
        }
    }

    public Date getCreated() {
        return created;
    }

    public FileSystemElement getParent() {
        return parent;
    }
}
