package me.findthepeach.myood.librarymanagement;

import java.util.UUID;

public class Book {
    private UUID bookId;
    private String title;
    private String author;
    private String ISBN;
    private String publicationYear;
    private BookStatus status;
    private UUID currentBorrowRecordId;

    public Book(String title, String author, String ISBN, String publicationYear) {
        this.bookId = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
    }

    public UUID getCurrentBorrowRecordId() {
        return currentBorrowRecordId;
    }

    public void setCurrentBorrowRecordId(UUID currentBorrowRecordId) {
        this.currentBorrowRecordId = currentBorrowRecordId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
