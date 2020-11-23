import data.*;

public class Main {
    public static void main(String[] args) {
        final String BURGER_TYPE_STANDARD="standard";
        final String BURGER_TYPE_HEALTHY="healthy";
        final String BURGER_TYPE_DELUXE="deluxe";
        Burger burger=new Burger(BURGER_TYPE_STANDARD,
                new  Ingredient("beef",1),
                new Ingredient("onion",1),
                new Ingredient("tomatoes",2),
                new Ingredient("pepper",1),
                new Ingredient("lettuce",1));

        System.out.println("The "+burger.getType()+ " burger cost £"+burger.getPrice());
        HealthyBurger healthyBurger=new HealthyBurger(
                new  Ingredient("beef",1),
                new Ingredient("tomatoes",2),
                new Ingredient("onion",1),
                new Ingredient("pepper",1),
                new Ingredient("lettuce",1),
                new Ingredient("cheese",1),
                new Ingredient("mushroom",1));
        System.out.println("The "+healthyBurger.getType()+ " burger meal cost £"+healthyBurger.getPrice());

       DeluxeBurger deluxeBurger=new DeluxeBurger(BURGER_TYPE_DELUXE,
               new  Ingredient("beef",1),
               true,
               new Drink("coke",1));
        System.out.println("The "+deluxeBurger.getType()+ " burger meal cost £"+deluxeBurger.getPrice());
    }
}
