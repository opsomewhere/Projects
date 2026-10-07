package SystemDesignProject.ZomatoBasicSystemDesign;

import SystemDesignProject.ZomatoBasicSystemDesign.Models.*;
import SystemDesignProject.ZomatoBasicSystemDesign.services.NotificationService;
import SystemDesignProject.ZomatoBasicSystemDesign.strategies.*;
import SystemDesignProject.ZomatoBasicSystemDesign.managers.*;
import SystemDesignProject.ZomatoBasicSystemDesign.factories.*;

import java.util.List;

public class TomatoApp {
    public TomatoApp(){
        initializeRestaurants();
    }

    public void initializeRestaurants(){
        // ================= RESTAURANT 1 =================
        Restaurant restaurant1 = new Restaurant("Taj Restaurant", "Bhopal");

        restaurant1.addMenuItems(new MenuItem("12", "Samosa", 12.0, "Fast Food", true));
        restaurant1.addMenuItems(new MenuItem("13", "Paneer Tikka", 180.0, "Starter", true));
        restaurant1.addMenuItems(new MenuItem("14", "Masala Dosa", 90.0, "South Indian", true));
        restaurant1.addMenuItems(new MenuItem("15", "Veg Biryani", 150.0, "Main Course", true));
        restaurant1.addMenuItems(new MenuItem("16", "Gulab Jamun", 60.0, "Dessert", true));


// ================= RESTAURANT 2 =================
        Restaurant restaurant2 = new Restaurant("Spice Garden", "Bhopal");

        restaurant2.addMenuItems(new MenuItem("17", "Paneer Butter Masala", 180.0, "Main Course", true));
        restaurant2.addMenuItems(new MenuItem("18", "Butter Naan", 40.0, "Indian Bread", true));
        restaurant2.addMenuItems(new MenuItem("19", "Veg Manchurian", 130.0, "Chinese", true));
        restaurant2.addMenuItems(new MenuItem("20", "Fried Rice", 120.0, "Chinese", true));
        restaurant2.addMenuItems(new MenuItem("21", "Ice Cream", 70.0, "Dessert", true));


// ================= RESTAURANT 3 =================
        Restaurant restaurant3 = new Restaurant("Food Junction", "Bhopal");

        restaurant3.addMenuItems(new MenuItem("22", "Veg Burger", 100.0, "Fast Food", true));
        restaurant3.addMenuItems(new MenuItem("23", "French Fries", 80.0, "Fast Food", true));
        restaurant3.addMenuItems(new MenuItem("24", "Pizza", 220.0, "Italian", true));
        restaurant3.addMenuItems(new MenuItem("25", "White Sauce Pasta", 160.0, "Italian", true));
        restaurant3.addMenuItems(new MenuItem("26", "Cold Coffee", 90.0, "Beverage", true));


// ================= RESTAURANT 4 =================
        Restaurant restaurant4 = new Restaurant("Royal Kitchen", "Bhopal");

        restaurant4.addMenuItems(new MenuItem("27", "Chole Bhature", 120.0, "North Indian", true));
        restaurant4.addMenuItems(new MenuItem("28", "Rajma Rice", 130.0, "North Indian", true));
        restaurant4.addMenuItems(new MenuItem("29", "Dal Tadka", 110.0, "Main Course", true));
        restaurant4.addMenuItems(new MenuItem("30", "Tandoori Roti", 25.0, "Indian Bread", true));
        restaurant4.addMenuItems(new MenuItem("31", "Rasmalai", 80.0, "Dessert", true));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
        restaurantManager.addRestaurant(restaurant4);
    }

    public List<Restaurant> searchRestaurants(String location){
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurants(User user,Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestuarant((restaurant));
    }

    public void addToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestuarant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first.");
            return;
        }
        for (MenuItem item : restaurant.getMenu()) {
            if (item.getId().equals(itemCode)) {
                user.getCart().addItems(item);
                break;
            }
        }
    }

    public Order checkoutNow(User user, String orderType, PaymentStrategy paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }
    public Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime) {
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduleTime));
    }

    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if (user.getCart().isEmpty()) return null;

        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestuarant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user, userCart, orderedRestaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if (isPaymentSuccess) {
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getId() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
    }


}
