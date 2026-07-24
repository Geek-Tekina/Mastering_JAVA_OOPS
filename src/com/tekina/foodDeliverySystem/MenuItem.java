package com.tekina.foodDeliverySystem;

public class MenuItem {

    // Generated : menuItemId

    // Mandatory : menuItemName, price, description

    // Optional : foodType (veg, nonVeg)

    // Mutable : menuItemName, price, description, foodType

    // Immutable : menuItemId

    private static int nextMenuItemId = 1;

    private final int menuItemId;

    private String menuItemName;
    private String description;
    private double price;
    private String foodType;

    public MenuItem(String menuItemName,
                    String description,
                    double price,
                    String foodType) {

        if (menuItemName == null || menuItemName.isBlank()) {
            throw new IllegalArgumentException("Menu item name cannot be null or empty.");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        this.menuItemId = nextMenuItemId++;
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = price;
        this.foodType = foodType;
    }

    public MenuItem(String menuItemName,
                    String description,
                    double price) {
        this(menuItemName, description, price, "");
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setMenuItemName(String menuItemName) {
        if (menuItemName == null || menuItemName.isBlank()) {
            throw new IllegalArgumentException("Menu item name cannot be null or empty.");
        }
        this.menuItemName = menuItemName;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemId=" + menuItemId +
                ", menuItemName='" + menuItemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}