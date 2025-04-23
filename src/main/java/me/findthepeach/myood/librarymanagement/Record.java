package me.findthepeach.myood.librarymanagement;

import java.time.LocalDate;
import java.util.UUID;

public class Record {
    private UUID bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Record(LocalDate borrowDate, UUID bookId) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
