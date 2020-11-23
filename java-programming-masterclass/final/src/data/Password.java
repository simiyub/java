package data;

public class Password {
    private static final int key = 748576362;
    private final int encyptedPassword;

    public Password(int password) {
        this.encyptedPassword = encrypt(password);
    }

    private int encrypt(int password) {
        return password ^ key;
    }
    public void storePassword(){
        System.out.println("Saving password as "+this.encyptedPassword);
    }
    public boolean letMeIn(int password){
        boolean in;
        if(encrypt(password)==this.encyptedPassword){
            System.out.println("Welcome");
            in=true;
        }
        else{
            System.out.println("No you cannot come in.");
            in=false;
        }
        return in;
    }
}
