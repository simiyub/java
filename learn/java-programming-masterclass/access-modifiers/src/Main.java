public class Main {
    public static void main(String[] args){
        Account myAccount = new Account("Tim");
        myAccount.deposit(199);
        myAccount.withdraw(98);
        myAccount.withdraw(-20);
        myAccount.deposit(-10);
        myAccount.calculateBalance();

        //fraud
        myAccount.transactions.add(2000);
        myAccount.calculateBalance();
        System.out.println(myAccount.getBalance());

        myAccount.balance=3000;
        System.out.println(myAccount.getBalance());
    }
}
