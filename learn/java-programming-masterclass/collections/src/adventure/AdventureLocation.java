package adventure;

import java.util.HashMap;
import java.util.Map;

public class AdventureLocation {
    private final int locationID;
    private final String description;
    private Map<String,Integer> exits=null;

    public AdventureLocation(int id, String description) {
        this.locationID = id;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    /***
     * Introduction immutability by making exists a parameter of the constructor.
     * Eliminating the need for create exits method.
     *
     * Java strategy: https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
     * */
    public AdventureLocation(int id, String description, Map<String, Integer> exits) {
        this.locationID = id;
        this.description = description;
        if(exits!=null){
            this.exits = new HashMap<>(exits);
            this.exits.put("Q", 0);
        }
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    public void addExit(String direction, int location) {
        exits.put(direction,location);
    }

    @Override
    public String toString() {
        return this.locationID+"\n"+this.description+"\nExits available: "+getExits();
    }

}
