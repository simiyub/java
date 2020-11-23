package data;

public class DeluxeBurger extends Burger {
    private final boolean chips;
    private final Drink drink;

    public DeluxeBurger(String type,
                        Ingredient meat,
                        boolean chips,
                        Drink drink) {
        super(type, meat);
        this.chips=chips;
        this.drink=drink;
    }

    public boolean isChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }

    @Override
    public double getPrice() {
        double finalPrice= super.getPrice();
        if(chips){
            finalPrice+=Pricer.getPrice("chips");
        }
        if(drink!=null){
            finalPrice+= drink.getPrice();
        }
        return finalPrice;
    }
}
