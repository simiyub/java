public class Main {
    public static void main(String[] args) {
        showChar();

        showBoolean();
    }

    private static void showChar() {
        char charValue = 'D';
        char unicodeValue = '\u00A9';
        System.out.println("\nstores one character e.g."+charValue+
                "\noccupies 16bits to allow storing unicode characters e.g."+unicodeValue);
    }

    private static void showBoolean() {
        boolean booleanValueTrue = true;
        boolean booleanValueFalse = false;

        boolean booleanIsCustomerOverTwenty = (2020-1980)>21;
        System.out.println("\nusing boolean to determine if over 21:"+booleanIsCustomerOverTwenty);
    }
}
