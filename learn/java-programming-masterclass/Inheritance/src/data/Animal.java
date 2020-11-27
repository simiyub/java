package data;

public class Animal {

    private final String name;
    private final int brain;
    private final int body;
    private final int size;
    private final int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name=name;
        this.brain=brain;
        this.body=body;
        this.size=size;
        this.weight=weight;
    }

    public void eat(String foodType){
        System.out.println(name+" eats "+foodType);
    }

    public void move(int speed){
        System.out.println("Animal moving at speed of "+speed+" steps per minute");
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
