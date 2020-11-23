public class Main {
    public static void main(String[] args) {
        String stringValue = "This is a string value";
        System.out.println("sequence of characters in double quotes\n" +
                "e.g.\n"+stringValue+
                "not a primitive type but a java class.\n" +
                "strings are immutable: once created cannot be changed.");

        System.out.println("\ncan also use unicode characters e.g."+"\u00A92020");

         String numberString1 = "250";
        String numberString2 = "250";
        System.out.println("\ndoesn't add what looks like int but treats them as string because they are strings:\n" +
                "250+250 as string is not 500 but: "+(numberString1+numberString2));

        String numberString300="300";
        int number300 = 300;
        System.out.println("\nadding a number such as int, float or double and string converts the int to string and concatenates the two:"+(numberString300+number300));
    }
}
