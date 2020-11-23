package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Mobile {

    /**Known issues with the mobile app to be resolved:
     * Can store spaces.
     * Does not validate phone numbers
     * **/

    private final String serialNumber;
    private final String make;
    private final String model;
    private final int manufactured;
    final String ADDING="Adding";
    final String UPDATING="Updating";
    final String REMOVING="Removing";
    private Scanner callerMenu;
            ArrayList<Contact> contacts = new ArrayList<>();
    public Mobile(String serialNumber, String make, String model, int manufactured) {
        this.serialNumber=serialNumber;
        this.make=make;
        this.model=model;
        this.manufactured=manufactured;

    }
    public void run() {
        callerMenu = new Scanner(System.in);
        boolean on=true;

        while(on){
            printMenu();
            System.out.println("What would you like to do? ");
            int action=callerMenu.nextInt();
            callerMenu.nextLine();
            switch (action){
                case 0:
                    printMenu();
                    break;
                case 1:
                    print();
                    break;
                case 2:
                    call();
                    break;
                case 3:
                    text();
                    break;
                case 4:
                    add();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    remove();
                    break;
                case 7:
                    System.out.println("Exiting..");
                    on=false;
                    break;
                default:
                    System.out.println("Invalid action selected. Exiting...");
                    on=false;
                    break;
            }
        }
    }

    private void add() {
        update(ADDING);
    }

    private void update()
    {
        update(UPDATING);
    }
    private void remove() {
        update(REMOVING);
    }


    private void update(String requestType) {
        final String TYPE_NUMBER="Please type the phone number of the contact:";
        final String TYPE_NAME="Please type the name of the contact:";

        String number="";

        while (number.isEmpty()){
            System.out.println(TYPE_NUMBER);
            number = callerMenu.nextLine();
            if(requestType.equalsIgnoreCase(REMOVING)){
                break;
            }
        }

        String name="";
        while(name.isEmpty()) {
            System.out.println(TYPE_NAME);
            name=callerMenu.nextLine();
        }

        if(requestType.equalsIgnoreCase(REMOVING)){
            System.out.println(REMOVING+" "+name+" "+number);
            remove(number,name);
        }
        else {
            System.out.println(requestType + ": " + name + " number:" + number);
            store(name, number);
            if (findNumber(number) != null) {
                System.out.println("Done.");
                print();
            } else {
                System.out.println("Failed.");
            }
        }
    }

    private void text() {
        System.out.println("Whom do you want to text?");
        String whom=callerMenu.nextLine();
        Contact contact = findName(whom);
        if(contact!=null){
            System.out.println("Please type your message below:");
            String message=callerMenu.nextLine();
            text(message,contact.getNumbers().get(0));
        }
        else{
            System.out.println("You cannot text without a valid contact."+whom);
        }
    }

    private void call() {
        System.out.println("Whom do you want to call?");
        String whom=callerMenu.nextLine();
        Contact contact = findName(whom);
        if(contact!=null){
            call(contact.getNumbers().get(0));
        }
        else{
            System.out.println("Could not call "+whom);
        }

    }


    private void printMenu() {
        System.out.println();
        System.out.println("Available Options");
        System.out.println("_________________");
        System.out.println("0-Print Menu\n" +
                "1-Show Contacts\n" +
                "2-Make a Call\n" +
                "3-Send a Text\n" +
                "4-Add a Contact\n" +
                "5-Update a Contact\n" +
                "6-Remove a Contact\n" +
                "7-Exit");
    }

    public void call(String number) {
        System.out.println("Calling "+number+" ...");
    }

    public void store(String number) {
        store("Unknown",number);
    }

    public void store(String name, String number) {
        System.out.println();
        System.out.println("Adding "+number+" to "+name+"..");
        Contact check=findNumber(number);
        if(check!=null){
            System.out.println(number+" already stored under "+check.getName()+". No update done.");
        }
        else{
            check=findName(name);
            if(check!=null){
                check.getNumbers().add(number);
                System.out.println("Found a contact called "+name+" and added "+number);
            }
            else{
                contacts.add(new Contact(number,name));
            }
        }
        print();
    }

    private void print() {
        System.out.println();
        if(!contacts.isEmpty()) {
            System.out.println("Contacts List Now");
            System.out.println("_________________");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println(contact.getName() + ":" + contact.getNumbers());
            }
        }
        else{
            System.out.println("Contacts List is Empty");
        }

    }

    public Contact findNumber(String number) {
        System.out.println();
        System.out.println("Searching for "+number+"...");
        for(int i=0;i<contacts.size();i++){
            Contact contact = contacts.get(i);
            if (contact.getNumbers().contains(number)){
                System.out.println("This is "+contact.getName()+"'s number.");
                return contact;
            }
        }
        System.out.println(number+" is not in your contacts.");
        return null;

    }

    public Contact findName(String name) {
        System.out.println();
        System.out.println("Searching for "+name+"...");
        for(int i=0;i<contacts.size();i++){
            Contact contact = contacts.get(i);
            if (contact.getName().contains(name)){
                System.out.println(name+" exists in your contacts with numbers:"+contact.getNumbers());
                return contact;
            }
        }

        System.out.println(name+" is not in your contacts.");
        return null;

    }



    public void remove(String number, String name) {
        Contact check=findName(name);
        if(check!=null){
            if(!number.isEmpty()){
                check.getNumbers().remove(number);
            }

            if(check.getNumbers().size()==0){
                contacts.remove(0);
                System.out.println("Removed "+name);
            }
            else{
                System.out.println("Removed "+number+" from "+name);
            }
            print();
        }
        else{
            System.out.println("Contact "+name+" "+number+" was not found.");
        }
    }

    public void text(String message, String number) {
        Contact contact = findNumber(number);
        if(contact!=null){
            String response = contact.text(message)?
                    "text sent":
                    "text send failed";
                    System.out.println(response);
        }
        else{
            System.out.println("You don't have "+number+"in your contacts. Did not send the message.");
        }
    }


}
