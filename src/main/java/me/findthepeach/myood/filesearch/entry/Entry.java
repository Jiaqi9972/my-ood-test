package me.findthepeach.myood.filesearch.entry;

public abstract class Entry {

    public String name;

    public Entry(String name) {
        this.name = name;
    }

    public abstract boolean isDirectory();
    public String getName() {
        return name;
    }
}
