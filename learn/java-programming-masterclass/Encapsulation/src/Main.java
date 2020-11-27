import data.PlayerEncapsulated;
import data.PlayerNoEncapsulation;
import data.Printer;
import data.Toner;

public class Main {
    public static void main(String[] args) {
        PlayerNoEncapsulation playerNoEncapsulation=new PlayerNoEncapsulation();
        playerNoEncapsulation.name="Peter";
        playerNoEncapsulation.health=10;
        playerNoEncapsulation.weapon="sword";
        playerNoEncapsulation.loseHealth(3);
        System.out.println("playerNoEncapsulation's health is now "+playerNoEncapsulation.health);

        PlayerEncapsulated playerEncapsulated = new PlayerEncapsulated("Peter",10,"sword");
        playerEncapsulated.loseHealth(3);

        Printer printer = new Printer("lexmark", "121",true);
        printer.addToner(new Toner("black",100));
        printer.print(100);
        printer.print(500);
        printer.print(99400);
    }
}
