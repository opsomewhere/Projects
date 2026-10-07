package SystemDesignProject.ZomatoBasicSystemDesign;

import SystemDesignProject.ZomatoBasicSystemDesign.Models.Order;
import SystemDesignProject.ZomatoBasicSystemDesign.Models.Restaurant;
import SystemDesignProject.ZomatoBasicSystemDesign.Models.User;
import SystemDesignProject.ZomatoBasicSystemDesign.strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {
    static void main(String[] args) {
        TomatoApp tomato = new TomatoApp();

        User op = new User(101, "Om Prakash", "opk@gmail.com", "773999xxxx", "Bhopal");
        op.displayUserDetails();

        List<Restaurant> restaurantList = tomato.searchRestaurants(op.getAddress());
        if(restaurantList.isEmpty()){
            System.out.println("No result Found!");
            return;
        }
        System.out.println("Found Restaurants near by you city :"+op.getAddress());
        for (Restaurant restaurant: restaurantList){
            System.out.println(" - "+restaurant.getName());
        }

        tomato.selectRestaurants(op, restaurantList.get(0));
        System.out.println("Selected restaurant : "+restaurantList.get(0).getName());

        tomato.addToCart(op,"12");
        tomato.addToCart(op,"13");
        tomato.printUserCart(op);

        Order order = tomato.checkoutNow(op,"Delivery",new UpiPaymentStrategy("192"));
        tomato.payForOrder(op,order);
    }
}
