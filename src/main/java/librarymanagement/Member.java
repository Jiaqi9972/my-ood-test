package librarymanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Member {
    private final String name;
    private final String memberId;
    private final Map<UUID, Record> history;
    private String contactInformation;
    private int currentBooks;
    private int maxBooks;
    private int loanDuration;

    public Member(String name, String memberId, String contactInformation, int maxBooks, int loanDuration) {
        this.name = name;
        this.memberId = memberId;
        this.contactInformation = contactInformation;
        this.history = new HashMap<>();
        this.maxBooks = maxBooks;
        this.loanDuration = loanDuration;
        this.currentBooks = 0;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setCurrentBooks(int currentBooks) {
        this.currentBooks = currentBooks;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public int getCurrentBooks() {
        return currentBooks;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public Map<UUID, Record> getHistory() {
        return history;
    }
}
