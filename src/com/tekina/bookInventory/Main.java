package com.tekina.bookInventory;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book(
                101,
                "The Human Mind",
                "BK Jha",
                3200.79,
                200
        );
        System.out.println(book1);
        book1.increaseStock(250);
        book1.decreaseStock(1000);
        book1.decreaseStock(140);
        System.out.println(book1);
    }
}