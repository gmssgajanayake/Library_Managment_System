package items.impl;

import items.LibraryItem;

public class Magazine implements LibraryItem {

    private final String id;
    private String title;
    private String publisher;
    private int issueNumber;

    public Magazine(String title, String publisher, int issueNumber) {
        this.id = "M-" + generateId();
        this.title = title;
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public Magazine(String id,String title, String publisher, int issueNumber) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
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
    public int compareTo(String title) {
        // If it is equal, this method returns 0
        return this.title.compareTo(title);
    }

    @Override
    public String toString() {
        return "Magazine \n\tid : " + id + "\n\ttitle : " + title + "\n\tpublisher : " + publisher + "\n\tissueNumber : " + issueNumber+"\n";
    }
}


