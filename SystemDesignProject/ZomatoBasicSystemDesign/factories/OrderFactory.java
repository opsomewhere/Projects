package SystemDesignProject.ZomatoBasicSystemDesign.factories;

import SystemDesignProject.ZomatoBasicSystemDesign.Models.*;
import SystemDesignProject.ZomatoBasicSystemDesign.strategies.*;

import java.util.List;


public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
