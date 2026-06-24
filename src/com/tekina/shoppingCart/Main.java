package com.tekina.shoppingCart;

public class Main {

    public static void main(String[] args) {

        Product laptop =
                new Product("Laptop", 60000);

        Product mouse =
                new Product("Mouse", 1500);

        Product keyboard =
                new Product("Keyboard", 3000);

        Customer customer =
                new Customer("Tekina");

        customer.getCart()
                .addProduct(laptop, 1);

        customer.getCart()
                .addProduct(mouse, 2);

        customer.getCart()
                .addProduct(keyboard, 1);

        customer.viewCart();

        double totalAfterPercentage =
                customer.getCart()
                        .applyDiscount(
                                new PercentageDiscount(10)
                        );

        System.out.println(
                "\nAfter 10% Discount = "
                        + totalAfterPercentage
        );

        double totalAfterFlat =
                customer.getCart()
                        .applyDiscount(
                                new FlatDiscount(500)
                        );

        System.out.println(
                "\nAfter Flat Discount = "
                        + totalAfterFlat
        );
    }
}