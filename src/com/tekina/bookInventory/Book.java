package com.tekina.bookInventory;

public class Book{
    private final int bookId;
    private String title;
    private String author;
    private double price;
    private int stockQuantity;

    public Book(int bId, String title, String author, double p, int q){
        this.bookId = bId;
        this.title = title;
        this.author = author;
        this.price = p;
        this.stockQuantity = q;
    }

    public void increaseStock(int q){
        if(q < 0){
            System.out.println("Can not increase by negative value.");
            return;
        }
        this.stockQuantity += q;
    }

    public void decreaseStock(int q){
        if(q > this.stockQuantity || q < 0){
            System.out.println("Can not decrease by this amount.");
            return;
        }
        this.stockQuantity -= q;
    }

    public void updatePrice(double p){
        if(p < 0){
            System.out.println("Can not set to negative value.");
            return;
        }
        this.price = p;
    }

    @Override
    public String toString(){
        return ("Book Id : " + this.bookId + "| Book Title : " + this.title + "| Book price : " + this.price
                + "| Book Author : " + this.author + "|Book Quantity : " + this.stockQuantity
        );
    }
}