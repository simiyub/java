package data;

/**
 * Final should only be assigned a value once and before the class instance is completed.
 * You can also mark a class or a method as final to prevent it from being extended.
 * **/

public class SomeClass {
    private static int classCounter = 0;
    private final  int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber=classCounter;
        System.out.println("instance = "+instanceNumber);
    }
}
