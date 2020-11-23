package data;

public class HealthyBurger extends Burger{

    private final Ingredient topping5;
    private final Ingredient topping6;

    public HealthyBurger(Ingredient meat,
                         Ingredient topping1,
                         Ingredient topping2,
                         Ingredient topping3,
                         Ingredient topping4,
                         Ingredient topping5,
                         Ingredient topping6) {
        super( "healthy",meat,topping1,topping2,topping3,topping4);
        setBread(new Ingredient("brown rye bread roll",1));
        this.topping5=topping5;
        this.topping6=topping6;
    }

    @Override
    public double getPrice() {
        double healthyPrice=super.getPrice();
        if(topping5!=null){
            healthyPrice+=topping5.getPrice();
        }
        if(topping6!=null){
            healthyPrice+=topping6.getPrice();
        }
        return healthyPrice;
    }
}
