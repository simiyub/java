import java.util.HashMap;
import java.util.Scanner;

public class PaymentManagerImpl implements PaymentManager {

    @Override
    public boolean paid() {
            Scanner paymentInterface = new Scanner(System.in);

            boolean paid=false;
            System.out.println("Select payment option:");
            System.out.println("1-Card\n" +
                    "2-Cash\n" +
                    "3-Cancel transaction");
            int option = paymentInterface.nextInt();


            switch(option){
                case 1:
                    paid = getCardPayment();
                    break;
                case 2:
                    paid = getCashPayment();
                    break;
                case 3:
                    System.out.println("Cancelling request.");
                    break;
                default:
                    System.out.println("Invalid payment option selected");
            }
            return paid;
        }

    private static boolean getCashPayment() {
        System.out.println("Processing cash payment.");
        return true;
    }


    private static boolean getCardPayment() {
        System.out.println("Processing card payment.");
        return true;
    }
}
