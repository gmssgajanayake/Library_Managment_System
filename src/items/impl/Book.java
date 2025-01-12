package items.impl;

import items.LibraryItem;

public class Book implements LibraryItem {

    private final String id; // System generates the id and not allows to change
    private String title;
    private String author;
    private int numberOfPages;

    public Book(String title, String author, int numberOfPages) {
        this.id = "B-" + generateId();
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
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
        return "Book \n\tid : " + id + "\n\ttitle : " + title + "\n\tauthor : " + author + "\n\tnumberOfPages : " + numberOfPages+"\n";
    }
}