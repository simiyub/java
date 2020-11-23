import data.GearBox;

/***
 * A way of logically grouping classes that are only used in one place
 * It increases encapsulation
 * Nested classes
 * More readable and maintainable code
 * 1. Static Nested Class - Associated with its outer class, accessed using the enclosing class name.
 * 2. Inner class - Associated with an instance of its enclosing class and has direct access to that object's methods and fields
 * 3. Local class - classes that are defined in a block, which is a group of zero or more statements between balanced braces. You typically find local classes defined in the body of a method
 * 4. Anonymous - Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time.
 * **/
public class InnerClasses {

     public static void main(String[] args) {
          GearBox mcLaren = new GearBox(9);
          mcLaren.addGear(1,10);
          mcLaren.addGear(2,30);
          mcLaren.addGear(3,40);
          mcLaren.addGear(4,60);
          mcLaren.addGear(5,80);
          mcLaren.addGear(6,150);

          mcLaren.operateClutch(true);
          mcLaren.changeGear(1);
          mcLaren.operateClutch(false);
          System.out.println(mcLaren.wheelSpeed(1000));
          mcLaren.changeGear(2);
          System.out.println(mcLaren.wheelSpeed(1000));
          mcLaren.operateClutch(true);
          mcLaren.changeGear(3);
          System.out.println(mcLaren.wheelSpeed(1000));

     }

}
