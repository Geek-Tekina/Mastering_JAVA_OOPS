package com.tekina.library;

public class Main {

    public static void main(String[] args) {

        // =========================================================
        // Create Library
        // =========================================================

        Library library = new Library("Tekina Public Library");

        // =========================================================
        // Create Authors
        // =========================================================

        Author author1 = new Author("Robert C. Martin");
        Author author2 = new Author("Joshua Bloch");
        Author author3 = new Author("Martin Fowler");

        // =========================================================
        // Create Books
        // =========================================================

        Book book1 = new Book("Clean Code", author1);
        Book book2 = new Book("Effective Java", author2);
        Book book3 = new Book("Refactoring", author3);
        Book book4 = new Book("Clean Architecture", author1);

        // =========================================================
        // Add Books to Library
        // =========================================================

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // =========================================================
        // Create Members
        // =========================================================

        Member member1 = new Member("Aniket Sharma", "aniket@gmail.com");
        Member member2 = new Member("Rahul Kumar", "rahul@gmail.com");

        // =========================================================
        // Register Members
        // =========================================================

        library.registerMember(member1);
        library.registerMember(member2);

        // =========================================================
        // Initial Library State
        // =========================================================

        System.out.println(library);

        library.displayAllBooks();

        library.displayMembers();

        // =========================================================
        // Borrow Books
        // =========================================================

        System.out.println("\n========== Borrow Operations ==========");

        library.borrowBook(member1.getMemberId(), book1.getBookNumber());

        library.borrowBook(member1.getMemberId(), book2.getBookNumber());

        library.borrowBook(member2.getMemberId(), book3.getBookNumber());

        // Trying to borrow an already borrowed book
        library.borrowBook(member2.getMemberId(), book1.getBookNumber());

        // =========================================================
        // Display Borrowed Books
        // =========================================================

        System.out.println();

        member1.displayBorrowedBooks();

        System.out.println();

        member2.displayBorrowedBooks();

        // =========================================================
        // Display Available Books
        // =========================================================

        library.displayAvailableBooks();

        // =========================================================
        // Return Book
        // =========================================================

        System.out.println("\n========== Return Operation ==========");

        library.returnBook(member1.getMemberId(), book1.getBookNumber());

        // =========================================================
        // Display Again
        // =========================================================

        System.out.println();

        member1.displayBorrowedBooks();

        library.displayAvailableBooks();

        // =========================================================
        // Remove Book
        // =========================================================

        System.out.println("\n========== Remove Book ==========");

        library.removeBook(book4.getBookNumber());

        library.displayAllBooks();

        // =========================================================
        // Remove Member
        // =========================================================

        System.out.println("\n========== Remove Member ==========");

        library.removeMember(member2.getMemberId());

        library.displayMembers();
    }
}