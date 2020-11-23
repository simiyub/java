package bank;

import bank.Account;
import bank.Bank;
import bank.Branch;
import bank.Transaction;

import java.util.ArrayList;

/**
*  Java autoboxes and unboxes as required.
* */
public class Main {
    private static ArrayList<Bank> banks;
    public static void main(String[] args) {
        example();
        banks = new ArrayList<>();

        setupNewBank("First Bank", "First Branch", "London", "First Customer", Account.CURRENT_ACCOUNT,"£", 100.00);
       setupNewBank("Second Bank", "Second Branch", "Paris", "Second Customer", Account.SAVINGS_ACCOUNT,"€", 200.00);
       Branch foundBranch = banks.get(1).findBranch("Second Branch", "Paris");
        System.out.println(foundBranch.getBranchNumber());
       Account foundAccount = foundBranch.findAccount("Second Customer",Account.SAVINGS_ACCOUNT,"€");
        System.out.println(foundAccount.getAccountNumber());

    }

    public static void setupNewBank(String name, String mainBranch, String mainBranchLocation, String firstCustomerName, String firstAccountType, String currency, double firstDepositAmount){

        if(!bankExists(name,mainBranch,mainBranchLocation)) {
            Transaction transaction = Transaction.transaction("opening", firstDepositAmount);
            int year = 2020;
            Account firstAccount = Account.account(firstCustomerName, firstAccountType, currency, year);
            firstAccount.transaction(transaction);
            Branch firstBranch = Branch.branch(mainBranch, mainBranchLocation);
            firstBranch.account(firstAccount);
            Bank newBank = Bank.bank(name, mainBranch, mainBranchLocation);
            newBank.branch(firstBranch);
            banks.add(newBank);
            System.out.println(banks);
        }
        else{
            System.out.println("Bank already exists.");
        }
    }

    private static boolean bankExists(String name, String mainBranch, String mainBranchLocation) {
        for(int i=0;i<banks.size();i++){
            Bank compare = banks.get(i);
            if(compare.getName().equalsIgnoreCase(name)
                    && compare.getMainBranch().equalsIgnoreCase(mainBranch)
            && compare.getMainBranchLocation().equalsIgnoreCase(mainBranchLocation)){
                return true;
            }
        }
        return false;
    }


    private static void example() {
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i=0;i<10;i++){
            ints.add(i);
        }
        System.out.println("numbers in an arraylist as integers:"+ints);

        ArrayList<Double> doubles=new ArrayList<>();
        for (int i=0;i<10;i++){
            doubles.add(Math.random());
        }
        System.out.println("numbers in an arraylist as doubles:"+doubles);

    }
}
