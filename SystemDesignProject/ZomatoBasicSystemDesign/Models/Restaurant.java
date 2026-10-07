package SystemDesignProject.ZomatoBasicSystemDesign.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestaurantID = 0;
    private int restaurantID;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String location){
        this.name = name;
        this.location = location;
        this.restaurantID = ++nextRestaurantID;
    }

    public String getName() {
        return name;
    }

    //setter for name
    public void setName(String name) {
        this.name = name;
    }

    //setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    // add Menu Items
    public void addMenuItems(MenuItem item){
        menu.add(item);
    }

    public String getLocation() {
        return location;
    }

    // Display info
    public void displayInfo() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║          RESTAURANT DETAILS          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ %-12s : %-20s ║%n", "ID", restaurantID);
        System.out.printf("║ %-12s : %-20s ║%n", "Name", name);
        System.out.printf("║ %-12s : %-20s ║%n", "Location", location);
        System.out.printf("║ %-12s : %-20s ║%n", "Menu Items", menu.size());
        System.out.println("╚══════════════════════════════════════╝");
    }


}




