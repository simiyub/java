package data;

public class PlayerNoEncapsulation {
    public String name;
    public  int health;
    public String weapon;
    public PlayerNoEncapsulation() {
    }

    public void loseHealth(int lost) {
        health = health-lost;
    }
}
