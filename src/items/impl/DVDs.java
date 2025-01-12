package items.impl;

import items.LibraryItem;

public class DVDs implements LibraryItem {

    private final String id;
    private String title;
    private String director;
    private int duration;

    public DVDs(String title, String director, int duration) {
        this.id = "D-" + generateId();
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(LibraryItem item) {
        // If it is equal, this method returns 0
        return this.title.compareTo(item.getTitle());
    }

    @Override
    public String toString() {
        return "DVD \n\tid : " + id + "\n\ttitle : " + title + "\n\tdirector : " + director + "\n\tduration : " + duration+"\n";
    }


}