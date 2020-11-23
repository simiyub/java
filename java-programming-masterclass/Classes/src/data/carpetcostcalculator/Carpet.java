package data.carpetcostcalculator;

public class Carpet {
    private double cost=0;

    public Carpet(double cost) {
        if(cost>0){
            this.cost = cost;
        }
    }

    public Carpet() {
        this(0);
    }

    public double getCost() {
        return cost;
    }
}
