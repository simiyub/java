package bank;

import java.util.ArrayList;

public class Branch {
    private int branchNumber;
    private static final int minBranchNumbers=5;
    private static final int maxBranchNumbers=10;
    private final String branchName;
    private final String branchLocation;
    private static final int firstBranchNumber =1;
    private ArrayList<Account> accounts;
    private static ArrayList<Integer> branchNumbers=new ArrayList<>();

    private Branch(String branchName, String branchLocation) {
        this.branchName=branchName;
        this.branchLocation=branchLocation;
    }
    static Branch branch(String branchName, String branchLocation) {
        Branch branch = new Branch(branchName, branchLocation);
        if (branchNumbers.size() < minBranchNumbers) {
            int lastBranchNumber = branchNumbers.size() == 0? 0 : branchNumbers.size()-1;
            for (int i = lastBranchNumber; i < maxBranchNumbers; i++) {
                lastBranchNumber++;
                branchNumbers.add(lastBranchNumber);
            }
        }
        branch.branchNumber = branchNumbers.get(0);
        branchNumbers.remove(0);
        return branch;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public Account findAccount(String accountName, String accountType, String currency) {
        for(int i=0;i<accounts.size();i++){
            Account account = accounts.get(i);
            if(account.getCustomerName().equalsIgnoreCase(accountName)
                    && account.getAccountType().equalsIgnoreCase(accountType)
            && account.getCurrency().equalsIgnoreCase(currency)){
                return account;
            }
        }
        return null;
    }

    ArrayList<Account> accounts() {
        return accounts;
    }

    void account(Account account) {
        if(this.accounts==null){
            accounts = new ArrayList<>();
        }
        this.accounts.add(account);
    }
}
