public class Main {

    private static int multiplier=5;

    public static void main(String[] args) {
        examples();

    }

    private static void examples() {
        StaticTest firstInstance = new StaticTest("First");
        System.out.println(firstInstance.toString());
        StaticTest secondInstance = new StaticTest("Second");
        System.out.println(secondInstance.toString());

        System.out.println(multiply(5));
    }

    private static int multiply(int num) {
        return num*multiplier;
    }

}
