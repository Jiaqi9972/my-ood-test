package me.findthepeach.myood.librarymanagement;

import me.findthepeach.myood.librarymanagement.service.BookService;
import me.findthepeach.myood.librarymanagement.service.BorrowService;
import me.findthepeach.myood.librarymanagement.service.MemberService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Library implements BookService, MemberService, BorrowService {
    private static Library instance;
    private final Map<UUID, Book> books;
    private final Map<String, Member> members;

    private Library(){
        this.books = new HashMap<>();
        members = new HashMap<>();
    }

    public synchronized static Library getInstance(){
        if(instance == null){
            instance =  new Library();
        }
        return instance;
    }

    @Override
    public synchronized UUID addBook(String title, String author, String ISBN, String publicationYear){
        Book book = new Book(title, author, ISBN, publicationYear);
        books.put(book.getBookId(), book);
        System.out.println("book added: " + book.getBookId());
        return book.getBookId();
    }

    @Override
    public synchronized void updateBook(UUID bookId, String title, String author, String ISBN, String publicationYear) {
        Book book = books.get(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setPublicationYear(publicationYear);
    }

    @Override
    public synchronized void removeBook(UUID bookId) {
        books.remove(bookId);
    }

    @Override
    public synchronized UUID borrowBook(UUID bookId, String memberId) {
        System.out.println(bookId + " borrowed: " + memberId);
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if(member.getCurrentBooks() < member.getMaxBooks() && book.getStatus() == BookStatus.AVAILABLE){
            book.setStatus(BookStatus.BORROWED);

            // update member record
            Record record = new Record(LocalDate.now(), bookId);
            UUID borrowRecordId = UUID.randomUUID();
            member.getHistory().put(borrowRecordId, record);
            member.setCurrentBooks(member.getCurrentBooks() + 1);
            System.out.println("Borrowed book " + bookId + " from member " + memberId);

            //update record to book
            book.setCurrentBorrowRecordId(borrowRecordId);

            return borrowRecordId;
        }else{
            System.out.println("Borrow failed.");
            return null;
        }
    }

    @Override
    public synchronized void returnBook(UUID bookId, String memberId, UUID borrowRecordId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        book.setStatus(BookStatus.AVAILABLE);
        member.setCurrentBooks(member.getCurrentBooks() - 1);
        LocalDate returnDate = LocalDate.now();
        LocalDate borrowDate = member.getHistory().get(borrowRecordId).getBorrowDate();
        member.getHistory().get(borrowRecordId).setReturnDate(returnDate);
        book.setCurrentBorrowRecordId(null);
        System.out.println("Returned book " + bookId + " from member " + memberId);

        if(ChronoUnit.DAYS.between(borrowDate, returnDate) > member.getLoanDuration()){
            System.out.println("Expired");
        }
    }

    @Override
    public synchronized void registerMember(String name, String memberId, String contactInformation, int maxBooks, int loanDuration) {
        Member member = new Member(name, memberId, contactInformation, maxBooks, loanDuration);
        members.put(memberId, member);
    }
}
