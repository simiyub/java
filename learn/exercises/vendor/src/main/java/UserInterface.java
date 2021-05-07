import java.util.*;

public class UserInterface {
    static Vendor vendor;
    static Map paymentOptions;
    static  PaymentManager paymentManager;
    static Scanner itemChoice;

    public static void main(String[] args) {
        boolean run = true;
        vendor = new VendorImpl();
        paymentManager = new PaymentManagerImpl();
        itemChoice = new Scanner(System.in);

        if (run){
            Item request = getItemRequired();
            if (request!=null){
                if(paymentManager.paid()){
                    run = vendor.vend(request.getItemCode(),request.getQuantity())!=null;
                }
                else{
                    System.out.println("Payment failed.");
                    run=false;
                }
            }
                run =false;

        }

    }


    private static Item getItemRequired() {
        System.out.println("Please enter item code");
        int itemCode = itemChoice.nextInt();
        int quantityLeft = vendor.checkStock(itemCode);

        if(quantityLeft!=0){
            itemChoice.nextLine();
            System.out.println("How many would you like?");
            int itemQuantity = itemChoice.nextInt();
            while(itemQuantity>quantityLeft){
                System.out.println("Only "+quantityLeft+" left. How many would you like?");
                itemQuantity = itemChoice.nextInt();
            }
            return new Item(itemCode,itemQuantity);
        }
        else{
            System.out.println("No item available for code "+itemCode);
        }
        return null;
    }
}
