package com.tekina.foodDeliverySystem;

public class Main {

    public static void main(String[] args) {

        FoodDeliveryApp app =
                new FoodDeliveryApp(
                        "Tekina Eats",
                        "Hungry? We Deliver!"
                );

        Restaurant restaurant =
                new Restaurant(
                        "Pizza Palace",
                        "Whitefield"
                );

        MenuItem pizza =
                new MenuItem(
                        "Farmhouse Pizza",
                        "Large Pizza",
                        399
                );

        MenuItem coke =
                new MenuItem(
                        "Coke",
                        "Cold Drink",
                        60
                );

        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(coke);

        app.registerRestaurant(restaurant);

        Customer customer =
                new Customer(
                        "Tekina",
                        "tekina@gmail.com",
                        "9876543210"
                );

        app.registerCustomer(customer);

        DeliveryPartner partner =
                new DeliveryPartner(
                        "Rahul",
                        "9999999999",
                        "DL123456"
                );

        app.registerDeliveryPartner(partner);

        customer.getCustomerCart().addItem(pizza, 2);
        customer.getCustomerCart().addItem(coke);

        System.out.println("Cart Total : ₹" +
                customer.getCustomerCart().calculateTotal());

        Order order =
                app.placeOrder(customer, restaurant);

        app.assignDeliveryPartner(
                order.getOrderId(),
                partner.getPartnerId()
        );

        System.out.println();

        app.displayOrders();
    }
}