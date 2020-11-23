import java.util.ArrayList;
import java.util.List;

public class Account {
    public String accountName;
    public int balance;
    public List<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount>0){
            transactions.add(amount);
            this.balance+=amount;
            System.out.println("deposited "+amount);
        }
        else {
            System.out.println(amount+" to deposit is less than zero.");
        }
    }

    public void withdraw(int amount){
        if (amount>0){
            this.transactions.add(amount);
            this.balance -=amount;
            System.out.println("withdrew "+amount);
        }
        else {
            System.out.println(amount+" to withraw is less than zero.");
        }
    }

    public void  calculateBalance(){
        this.balance = 0;
        for (int amount:transactions){
            this.balance+=amount;
        }
        System.out.println("balance is "+this.balance);
    }
}
