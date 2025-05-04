package librarymanagement.service;

import java.util.UUID;

public interface BookService {
    UUID addBook(String title, String author, String ISBN, String publicationYear);
    void updateBook(UUID bookId, String title, String author, String ISBN, String publicationYear);
    void removeBook(UUID bookId);
}
