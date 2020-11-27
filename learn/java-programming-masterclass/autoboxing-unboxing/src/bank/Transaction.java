package bank;

public class Transaction {
    private final String description;
    private final double amount;
    private static int nextTransactionID=1;
    private int ID;

    private Transaction(String description, double amount){
        this.description=description;
        this.amount=amount;
    }
    public static Transaction transaction(String description, double amount){
        Transaction transaction = new Transaction(description,amount);
        transaction.ID=nextTransactionID;
        nextTransactionID++;
        return transaction;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public int getID() {
        return ID;
    }

    private void setID(int nextTransactionID) {
        this.ID=nextTransactionID;
            }
}
