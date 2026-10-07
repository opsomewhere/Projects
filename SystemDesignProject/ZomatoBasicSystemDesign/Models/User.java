package SystemDesignProject.ZomatoBasicSystemDesign.Models;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Cart cart;

    public User ( int id,String name, String email, String phone, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cart = new Cart();
    }

    // setter of ID
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    //getter for name
    public String getName() {
        return name;
    }


    //getter for email
    public String getEmail() {
        return email;
    }

    //getter for phone
    public String getPhone() {
        return phone;
    }

    //getter for cart
    public Cart getCart() {
        return cart;
    }

    //Setter and geeter for address
    public void setAddress(String address) { this.address = address;}
    public String getAddress() { return address;}

    public void displayUserDetails() {
        System.out.println("\n========================================");
        System.out.println("              USER DETAILS              ");
        System.out.println("========================================");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);
        System.out.println("Address    : " + address);
        System.out.println("========================================\n");
    }
}
