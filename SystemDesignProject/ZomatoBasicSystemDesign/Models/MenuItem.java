package SystemDesignProject.ZomatoBasicSystemDesign.Models;

public class MenuItem {
    private String id;
    private String name;
    private double price;
    private String categories;
    private boolean isVeg;

    public MenuItem(String  id,String name, double price, String categories, Boolean isveg){
        this.id = id;
        this.name= name;
        this.price = price;
        this.categories = categories;
        this.isVeg = isveg;
    }

    public String getName() {
        return name;
    }

    //setter for id
    public void setId(String id) { this.id = id;}

    public void setName(String name) { this.name = name; }

    public void setCategories(String categories) { this.categories = categories;}

    public void setPrice(double price) { this.price = price;}
    public double getPrice() { return price;}

    public void setVeg(boolean veg) { isVeg = veg;}

    public String getId() {
        return id;
    }

    // Display info
    public void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("              PRODUCT INFO              ");
        System.out.println("========================================");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Price      : ₹" + price);
        System.out.println("Category   : " + categories);
        System.out.println("Vegetarian : " + (isVeg ? "Yes" : "No"));
        System.out.println("========================================\n");
    }


}
