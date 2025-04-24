package me.findthepeach.myood.filesearch.entry;

public class File extends Entry{
    public long size;
    public String extension;

    public File(String name ,String extension, long size) {
        super(name);
        this.extension = extension;
        this.size = size;
        System.out.println("File created: " + name);
    }

    @Override
    public boolean isDirectory(){
        return false;
    }

    public long getSize(){
        return size;
    }

    public String getExtension(){
        return extension;
    }

    public String getDescription(){
        return "File: " + name + "." + extension +" (" + size + " bytes)";
    }
}
