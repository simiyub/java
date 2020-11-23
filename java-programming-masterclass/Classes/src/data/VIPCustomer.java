package data;

public class VIPCustomer {
    private double creditLimit;
    private String email;
    private String name;

    public VIPCustomer(){
        this("default", 100.00, "default@bank.com");
        System.out.println("default constructor called");
    }


    public VIPCustomer(String name, double creditLimit, String email) {
        this.name=name;
        this.creditLimit=creditLimit;
        this.email=email;
        System.out.println("constructor with fields set called.");
    }

    public VIPCustomer(String name, String email) {
        this(name,10.00,email);
        System.out.println("two value constructor called.");
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
