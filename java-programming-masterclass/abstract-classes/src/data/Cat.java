package data;

public class Cat extends Animal {


    @Override
    public void eat() {
        System.out.println("Swallows");
    }

    @Override
    public void move() {
        System.out.println("stealth is the game.");
    }
}
