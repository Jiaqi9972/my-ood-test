package me.findthepeach.myood.librarymanagement.service;

import java.util.UUID;

public interface BorrowService {
    UUID borrowBook(UUID bookId, String memberId);
    void returnBook(UUID bookId, String memberId, UUID borrowRecordId);
}
