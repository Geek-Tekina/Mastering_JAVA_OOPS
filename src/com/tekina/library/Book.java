package com.tekina.library;

public class Book {

    /*
        Generated Fields : bookNumber

        Mandatory Fields : bookName, author

        Optional Fields : borrowedBy

        Mutable Fields : borrowedBy

        Immutable Fields : bookNumber, bookName, author

        Relationship Type :
        Book HAS Author      -> Aggregation
        Book HAS Member      -> Association (only while borrowed)

        Responsibilities :
        - Maintain its own details.
        - Know whether it is available.
        - Allow itself to be borrowed.
        - Allow itself to be returned.
    */

    private static int nextBookNumber = 1;

    private final int bookNumber;
    private final String bookName;
    private final Author author;

    private Member borrowedBy;

    public Book(String bookName, Author author) {

        if (bookName == null || bookName.isBlank()) {
            throw new IllegalArgumentException("Book name cannot be null or blank.");
        }

        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }

        this.bookNumber = nextBookNumber++;
        this.bookName = bookName;
        this.author = author;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public boolean borrow(Member member) {

        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if (!isAvailable()) {
            return false;
        }

        borrowedBy = member;
        return true;
    }

    public boolean returnBook() {

        if (isAvailable()) {
            return false;
        }

        borrowedBy = null;
        return true;
    }

    @Override
    public String toString() {

        String status = isAvailable()
                ? "Available"
                : "Borrowed by " + borrowedBy.getName();

        return "Book {" +
                "Book No=" + bookNumber +
                ", Name='" + bookName + '\'' +
                ", Author='" + author.getName() + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}