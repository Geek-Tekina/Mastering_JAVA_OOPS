package com.tekina.library;

import java.util.ArrayList;
import java.util.List;

public class Member {

    /*
        Generated Fields : memberId

        Mandatory Fields : name, email

        Optional Fields : borrowedBooks

        Mutable Fields : name, email, borrowedBooks

        Immutable Fields : memberId

        Relationship Type :
        Member HAS Books (Aggregation)

        Responsibilities :
        - Maintain member details.
        - Keep track of borrowed books.
        - Know whether more books can be borrowed.
    */

    private static int nextMemberId = 1;

    private final int memberId;
    private String name;
    private String email;
    private final List<Book> borrowedBooks;

    public Member(String name, String email) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member name cannot be null or blank.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        this.memberId = nextMemberId++;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    // ===========================
    // Getters
    // ===========================

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // ===========================
    // Setters
    // ===========================

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
    }

    public void setEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        this.email = email;
    }

    // ===========================
    // Business Methods
    // ===========================

    public boolean canBorrowMoreBooks() {
        return borrowedBooks.size() < 5;
    }

    public boolean borrow(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        if (borrowedBooks.contains(book)) {
            System.out.println("Book is already borrowed by this member.");
            return false;
        }

        borrowedBooks.add(book);
        return true;
    }

    public boolean returnBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        return borrowedBooks.remove(book);
    }

    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }

    public void displayBorrowedBooks() {

        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
            return;
        }

        System.out.println("\nBooks borrowed by " + name + ":");

        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {

        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}