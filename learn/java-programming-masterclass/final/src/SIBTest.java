public class SIBTest {

    public static final String owner;
    static {
        owner = "Tim";
        System.out.println("SIBTest static initialisation block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }
    static {
        System.out.println("Second initialisation block called.");
    }
    public void someMethod(){
        System.out.println("Some method called.");
    }
}
