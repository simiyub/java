package data;

import java.util.Comparator;
import java.util.Date;

public abstract class Item implements Comparable{
    String name;
    String source;
    double cost;
    String sourceDate;
    public static Item newItem(String name, String source, double cost, String sourceDate) {
        return item(name,source,cost,sourceDate);
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public double getCost() {
        return cost;
    }

    public String getSourceDate() {
        return sourceDate;
    }

    private static Item item(String name, String source, double cost, String sourceDate) {
        Item item=null;
        switch(name.toLowerCase()) {

            case "car":
                item = new Car(name,source,cost,sourceDate);
                break;

            default:
                System.out.println("unknown item type"+name);
                break;

        }
return item;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
