package org.solidEdu.s;




public class Book implements BookHandler {

    private BookPersistence bookPersistence;
    private String authorName;
    private int numOfPages;

    public Book(String authorName, int numOfPages) {
        this.authorName = authorName;
        this.numOfPages = numOfPages;
        this.bookPersistence = new BookPersistence();
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public void save() {
        this.bookPersistence.save(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + ' ' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
