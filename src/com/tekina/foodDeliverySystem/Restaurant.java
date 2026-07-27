package com.tekina.foodDeliverySystem;

public class Restaurant {

    // Generated : restaurantId, restaurantMenu (Menu)

    // Mandatory : name, location

    // Optional :

    // Mutable : name, location

    // Immutable : restaurantId, restaurantMenu

    private static int nextRestaurantId = 1;

    private final int restaurantId;

    private final Menu restaurantMenu;

    private String name;
    private String location;

    public Restaurant(String name,
                      String location) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty or NULL");
        }
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location can not be NULL or empty");
        }

        this.location = location;
        this.name = name;
        this.restaurantId = nextRestaurantId++;
        this.restaurantMenu = new Menu();
    }

    public boolean addMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        return this.restaurantMenu.addMenuItem(menuItem);
    }

    public boolean removeMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        return this.restaurantMenu.removeMenuItem(menuItem.getMenuItemId());
    }

    public boolean updatePrice(MenuItem menuItem,
                               double newPrice) {
        if (menuItem == null || newPrice <= 0) {
            return false;
        }

        MenuItem item = this.restaurantMenu.getMenuItem(menuItem.getMenuItemId());
        if (item == null) {
            return false;
        }

        item.setPrice(newPrice);
        return true;
    }

    public MenuItem searchMenuItem(int menuItemId) {
        return this.restaurantMenu.getMenuItem(menuItemId);
    }

    public Menu getMenu() {
        return this.restaurantMenu;
    }

    public int getRestaurantId() {
        return this.restaurantId;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty or NULL");
        }
        this.name = name;
    }

    public void setLocation(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location can not be NULL or empty");
        }
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", totalMenuItems=" + restaurantMenu.getMenuItems().size() +
                '}';
    }
}