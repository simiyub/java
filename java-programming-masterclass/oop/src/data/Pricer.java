package data;

public class Pricer {
    public static double getPrice(String name) {
        switch(name){
            case "white bread":
            case "chips":
                return 1.0;
            case "beef":
            case"coke":
                return 1.5;
            case "tomatoes":
            case "onion":
            case "cheese":
                return 0.5;
            case "pepper":
            case "ketchup":
            case "lettuce":
            case "mushroom":
                return 0.2;
        }
        return 0;
    }
}
