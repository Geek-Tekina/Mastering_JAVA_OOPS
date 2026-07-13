package com.tekina.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    /*
        Generated Fields : registrationNumber

        Mandatory Fields : name

        Optional Fields : books, members

        Mutable Fields : books, members

        Immutable Fields : registrationNumber, name

        Responsibilities :
        - Maintain books.
        - Maintain members.
        - Coordinate borrowing.
        - Coordinate returning.
        - Search books.
        - Search members.
    */

    private static int nextRegistrationNumber = 1;

    private final int registrationNumber;
    private final String name;

    private final List<Book> books;
    private final List<Member> members;

    public Library(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Library name cannot be null or blank.");
        }

        this.registrationNumber = nextRegistrationNumber++;
        this.name = name;

        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // =========================================================
    // Book Operations
    // =========================================================

    public boolean addBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        if (books.contains(book)) {
            System.out.println("Book already exists in library.");
            return false;
        }

        books.add(book);
        return true;
    }

    public boolean removeBook(int bookNumber) {

        Book book = findBookById(bookNumber);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Cannot remove a borrowed book.");
            return false;
        }

        books.remove(book);
        return true;
    }

    public Book findBookById(int bookNumber) {

        for (Book book : books) {

            if (book.getBookNumber() == bookNumber) {
                return book;
            }
        }

        return null;
    }

    public void displayAvailableBooks() {

        System.out.println("\n===== Available Books =====");

        boolean found = false;

        for (Book book : books) {

            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books available.");
        }
    }

    public void displayAllBooks() {

        System.out.println("\n===== Library Books =====");

        if (books.isEmpty()) {
            System.out.println("Library has no books.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // =========================================================
    // Member Operations
    // =========================================================

    public boolean registerMember(Member member) {

        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if (members.contains(member)) {
            System.out.println("Member already registered.");
            return false;
        }

        members.add(member);
        return true;
    }

    public boolean removeMember(int memberId) {

        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (member.getBorrowedBookCount() > 0) {
            System.out.println("Member still has borrowed books.");
            return false;
        }

        members.remove(member);
        return true;
    }

    public Member findMemberById(int memberId) {

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    public void displayMembers() {

        System.out.println("\n===== Registered Members =====");

        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }

    // =========================================================
    // Borrow / Return Operations
    // =========================================================

    public boolean borrowBook(int memberId, int bookNumber) {

        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        Book book = findBookById(bookNumber);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!member.canBorrowMoreBooks()) {
            System.out.println("Member has already borrowed maximum books.");
            return false;
        }

        if (!book.borrow(member)) {
            System.out.println("Book is already borrowed.");
            return false;
        }

        member.borrow(book);

        System.out.println("Book borrowed successfully.");

        return true;
    }

    public boolean returnBook(int memberId, int bookNumber) {

        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        Book book = findBookById(bookNumber);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!member.returnBook(book)) {
            System.out.println("Member has not borrowed this book.");
            return false;
        }

        book.returnBook();

        System.out.println("Book returned successfully.");

        return true;
    }

    @Override
    public String toString() {

        return "Library{" +
                "registrationNumber=" + registrationNumber +
                ", name='" + name + '\'' +
                ", totalBooks=" + books.size() +
                ", totalMembers=" + members.size() +
                '}';
    }
}