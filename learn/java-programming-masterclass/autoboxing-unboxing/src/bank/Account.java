package bank;

import java.util.ArrayList;

public class Account {
    public static final String CURRENT_ACCOUNT="CURRENT";
    public static final String SAVINGS_ACCOUNT ="SAVINGS";
    private final String currency;
    private String customerName;
    private String accountType;
    private int year;
    public static final String DEFAULT_CURRENCY="£";
    private static int nextAccountNumber=1;
    private ArrayList<Transaction> transactions;
    private int accountNumber;

    private Account(String customerName, String accountType, String currency, int year){
        this.customerName=customerName;
        this.accountType=accountType;
        this.currency=currency;
        this.year=year;


    }
    public static Account account(String customerName, String accountType, String currency, int year){
        Account account=new Account( customerName,  accountType,  currency,year);
        account.accountNumber=nextAccountNumber;
        nextAccountNumber++;

        return account;
    }

    private void setAccountNumber(int nextAccountNumber) {
        this.accountNumber=nextAccountNumber;
    }

    String getCustomerName() {
        return customerName;
    }

    String getAccountType() {
        return accountType;
    }

    int getYear() {
        return year;
    }

    String getCurrency() {
        return currency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    ArrayList<Transaction> transactions() {
        return transactions;
    }

    public boolean transaction(Transaction transaction) {
        if(transactions==null){
            transactions=new ArrayList<>();
        }
        transactions.add(transaction);
        return transactions.contains(transaction);
    }
}
