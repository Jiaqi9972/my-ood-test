package me.findthepeach.myood.filesearch.fileelement;

public class File extends FileSystemElement{
    private long size;
    private String extension;

    public File(String name, FileSystemElement parent, long size, String extension) {
        super(name, parent);
        this.size = size;
        this.extension = extension;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    public String getExtension() {
        return this.extension;
    }
}
