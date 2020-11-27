package data;

import java.util.ArrayList;

public class Contact {
    private final String name;
    private ArrayList<String> numbers;
    private ArrayList<String> messages;

    public Contact(String number, String name) {
        this.name=name;
        numbers = new ArrayList<>();
        numbers.add(number);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public boolean text(String message) {
        if(messages==null){
            messages=new ArrayList<>();
        }
        return messages.add(message);
    }
}
