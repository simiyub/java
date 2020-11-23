package data;

public class PlayerEncapsulated {
    //Attributes of the player are not exposed
    private final String name;
    private int health=0;

    public PlayerEncapsulated(String name, int health, String weapon) {
        this.name=name;
        if(health>0 && health<=100){
            this.health=health;
        }
    }

    public void loseHealth(int loss) {
        this.health=health-loss;
        System.out.println("lost "+loss+". health now is "+health);
    }
}
