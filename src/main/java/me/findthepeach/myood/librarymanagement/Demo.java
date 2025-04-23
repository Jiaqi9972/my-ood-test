package me.findthepeach.myood.librarymanagement;

import java.util.UUID;

/*
* The library management system should allow librarians to manage books, members, and borrowing activities.
The system should support adding, updating, and removing books from the library catalog.
Each book should have details such as title, author, ISBN, publication year, and availability status.
The system should allow members to borrow and return books.
Each member should have details such as name, member ID, contact information, and borrowing history.
The system should enforce borrowing rules, such as a maximum number of books that can be borrowed at a time and loan duration.
The system should handle concurrent access to the library catalog and member records.
The system should be extensible to accommodate future enhancements and new features.
* */
public class Demo {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        //add books
        UUID bookId1 = library.addBook("Book1", "Tom", "213131", "1998");
        UUID bookId2 =  library.addBook("Book2", "Tom", "55345345", "2005");
        UUID bookId3 = library.addBook("Book3", "Sam", "2187323", "2020");

        //add member
        library.registerMember("Peter", "LIB100", "12345", 2,14);

        //borrow books
        UUID record1 = library.borrowBook(bookId1, "LIB100");
        UUID record2 = library.borrowBook(bookId2, "LIB100");
        UUID record3 = library.borrowBook(bookId3, "LIB100");

        //return books
        library.returnBook(bookId1, "LIB100", record1);
        library.returnBook(bookId2, "LIB100", record2);

    }
}
