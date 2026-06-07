package com.tekina.bookInventory;

public class Book{
    private final int bookId;
    private String title;
    private String author;
    private double price;
    private int stockQuantity;

    public Book(int bookId, String title, String author, double price, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stockQuantity = quantity;
    }

    public void increaseStock(int quantity){
        if(quantity < 0){
            System.out.println("Can not increase by negative value.");
            return;
        }
        this.stockQuantity += quantity;
    }

    public void decreaseStock(int quantity){
        if(quantity > this.stockQuantity || quantity < 0){
            System.out.println("Can not decrease by this amount.");
            return;
        }
        this.stockQuantity -= quantity;
    }

    public void updatePrice(double price){
        if(price < 0){
            System.out.println("Can not set to negative value.");
            return;
        }
        this.price = price;
    }

    @Override
    public String toString(){
        return ("Book Id : " + this.bookId + "| Book Title : " + this.title + "| Book price : " + this.price
                + "| Book Author : " + this.author + "|Book Quantity : " + this.stockQuantity
        );
    }
}