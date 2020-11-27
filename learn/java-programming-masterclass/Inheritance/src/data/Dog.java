package data;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int teeth;
    private int tails;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tails, int teeth, String coat)
    {
        super(name,1,1,size,weight);
        this.eyes=eyes;
        this.legs=legs;
        this.tails=tails;
        this.teeth=teeth;
        this.coat=coat;


    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }

    public int getTails() {
        return tails;
    }

    public void setTails(int tails) {
        this.tails = tails;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog can chew.");
    }

    @Override
    public void eat(String foodType) {
        chew();
        super.eat(foodType);
        System.out.println("Dog bites and chews.");
    }
    public void walk(){
        System.out.println("Dog can walk.");
        move(10);
    }
    public void run()
    {
        System.out.println("Dog can run.");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog moving.");
        moveLegs();
        super.move(speed);
    }

    private void moveLegs() {
        System.out.println("Dog moving legs.");
    }
}
