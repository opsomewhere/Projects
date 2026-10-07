package SystemDesignProject.ZomatoBasicSystemDesign.Models;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<MenuItem> items = new ArrayList<>();
    private Restaurant restaurant;

    public Cart(){
        restaurant = null;
    }

    //addItem -> check restro:T -> item++
    public void addItems(MenuItem item){
        if(restaurant == null){
            System.err.println("Cart: Set a restaurant before adding items.");
            return;
        }
        items.add(item);
    }

    public double getTotalCost(){
        double sum = 0;
        for(MenuItem it:items){
            sum += it.getPrice();
        }
        return sum;
    }

    public boolean isEmpty(){
        return  restaurant == null || items.isEmpty();
    }

    public void clear(){
        items.clear();
        restaurant = null;
    }

    // Getter & setter for Restaurant
    public void setRestuarant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public Restaurant getRestuarant() {
        return restaurant;
    }

    //MenuItems
    public List<MenuItem> getItems() {
        return items;
    }

}


