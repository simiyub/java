package data;

import java.util.ArrayList;
import java.util.List;

public class GearBox {
    private List<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchEngaged;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears=new ArrayList<>();
        Gear neutral = new Gear(0,0);
    }

    public void operateClutch(boolean in){
        this.clutchEngaged = in;
    }

    public void addGear(int number, double ratio){
        if(number>0 && number<maxGears){
            this.gears.add(new Gear(number, ratio));
            System.out.println("Gear"+number+" added.");
        }
    }

    public void changeGear(int newGear){
        if(this.clutchEngaged && newGear>=0 && newGear<this.gears.size()){
            this.currentGear=newGear;
            System.out.println("Gear changed to "+newGear);
        }
        else{
            System.out.println("Grind");
            this.currentGear=0;
        }
    }

    public double wheelSpeed(int revs){
        if(clutchEngaged){
            System.out.println("Scream");
            return 0;
        }
        return revs * gears.get(currentGear).getSpeed();
    }

    public class Gear {
        private final int number;
        private final double speed;

        Gear(int number, double speed) {
            this.number=number;
            this.speed=speed;
        }

        int getNumber() {
            return number;
        }

        double getSpeed() {
            return speed;
        }
    }
}
