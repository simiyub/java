package data;

public class Burger {
    private final String type;
    private Ingredient bread;
    private final Ingredient meat;
    private Ingredient topping1;
    private Ingredient topping2;
    private Ingredient topping3;
    private Ingredient topping4;
    private double price;
    private  double basePrice;

    public Burger(String type, Ingredient meat) {
        if(type.equalsIgnoreCase("standard") || type.equalsIgnoreCase("deluxe")){
            this.bread = new Ingredient("white bread",1);
        }
        else if (type.equalsIgnoreCase("healthy")){
            this.bread=new Ingredient("brown rye bread roll",1);
        }
        this.type=type;
        this.meat =meat;
        basePrice=this.meat.getPrice();
        if(this.bread!=null){
            basePrice+=this.bread.getPrice();
        }

    }

    public Burger(String type,Ingredient meat, Ingredient topping1, Ingredient topping2, Ingredient topping3, Ingredient topping4) {
        this(type,meat);
        this.topping1=topping1;
        this.topping2=topping2;
        this.topping3=topping3;
        this.topping4=topping4;
    }
    public void setBread(Ingredient bread) {
        this.bread = bread;
    }

    public Ingredient getBread() {
        return bread;
    }

    public Ingredient getMeat() {
        return meat;
    }

    public Ingredient getTopping1() {
        return topping1;
    }

    public void setTopping1(Ingredient topping1) {
        this.topping1 = topping1;
    }

    public Ingredient getTopping2() {
        return topping2;
    }

    public void setTopping2(Ingredient topping2) {
        this.topping2 = topping2;
    }

    public Ingredient getTopping3() {
        return topping3;
    }

    public void setTopping3(Ingredient topping3) {
        this.topping3 = topping3;
    }

    public Ingredient getTopping4() {
        return topping4;
    }

    public void setTopping4(Ingredient topping4) {
        this.topping4 = topping4;
    }

    public double getBasePrice() {
        return basePrice;
    }
    public double getPrice() {

        double toppingPrice=0;
        if(topping1!=null){
            toppingPrice+=topping1.getPrice();
        }
        if(topping2!=null){
            toppingPrice+=topping2.getPrice();
        }
        if(topping3!=null){
            toppingPrice+=topping3.getPrice();
        }
        if(topping4!=null){
            toppingPrice+=topping4.getPrice();
        }
        return this.basePrice+toppingPrice;
    }

    public String getType() {
        return type;
    }
}

