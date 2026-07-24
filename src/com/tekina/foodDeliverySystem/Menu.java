package com.tekina.foodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // Generated : menuId

    // Mandatory :

    // Optional : menuItems (MenuItem)

    // Mutable : menuItems

    // Immutable : menuId

    private static int nextMenuId = 1;

    private final int menuId;

    private final List<MenuItem> menuItems;

    public Menu() {
        this.menuId = nextMenuId++;
        this.menuItems = new ArrayList<>();
    }

    public boolean addMenuItem(MenuItem menuItem) {

        if (menuItem == null) {
            return false;
        }

        return this.menuItems.add(menuItem);
    }

    public boolean removeMenuItem(int menuItemId) {

        MenuItem item = getMenuItem(menuItemId);

        if (item == null) {
            return false;
        }

        return this.menuItems.remove(item);
    }

    public MenuItem getMenuItem(int menuItemId) {

        for (MenuItem item : this.menuItems) {

            if (item.getMenuItemId() == menuItemId) {
                return item;
            }

        }

        return null;
    }

    public void displayMenu() {

        if (this.menuItems.isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }

        for (MenuItem item : this.menuItems) {
            System.out.println(item);
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public int getMenuId() {
        return menuId;
    }

    @Override
    public String toString() {

        return "Menu{" +
                "menuId=" + menuId +
                ", totalItems=" + menuItems.size() +
                '}';
    }
}