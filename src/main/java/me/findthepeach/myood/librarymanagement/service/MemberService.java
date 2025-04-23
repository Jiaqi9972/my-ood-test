package me.findthepeach.myood.librarymanagement.service;

public interface MemberService {
    void registerMember(String name, String memberId, String contactInformation, int maxBooks, int loanDuration);
}
