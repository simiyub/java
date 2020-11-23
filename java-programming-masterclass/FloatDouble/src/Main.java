public class Main {

    public static void main(String[] args) {
        //Two primitive times for expressing floating numbers
        //Float is a single precision - occupies 32bits
        //Double is a double precision - occupies 64bits
        System.out.println("Two primitive types for expressing floating numbers:\n" +
                "Float is a single precision - occupies 32bits\n"+
                "Double is a double precision - occupies 64bits");

        floatDouble();

        casting();

        challenge();
    }

    private static void challenge() {
        //Convert pounds to kilograms
        double pounds = 5.25;
        double kilos = 5.25*0.45359237;
        System.out.println("\nchallenge\n" +
                "========\npounds to kilos:\n" +
                ""+pounds+"pounds="+kilos+"kilos");
    }

    private static void casting() {
        float doubleCasting = (float) 5.25;
        System.out.println("\ndouble cast to float:"+doubleCasting);
    }

    private static void floatDouble() {
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println("\nmin and max for float:");
        System.out.println("Float min value = "+minFloat);
        System.out.println("Float max value = "+maxFloat);

        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("\nmin and max for double:");
        System.out.println("Double min value = "+minDouble);
        System.out.println("Double max value = "+maxDouble);

        int intValue = 5/3;
        float floatValue = 5f/3f;
        double doubleValue = 5d/3d;
        System.out.println("\nYou get more precision with floating point numbers\n"+"intValue="+intValue+",floatValue="+floatValue+",doubleValue="+doubleValue);
        System.out.println("Despite double using double space of float. Double is recommended because\n" +
                "1. chips have been optimised to process doubles faster.\n" +
                "2. many java maths functions use doubles for it's precision. To utilise them, you'll need double.\n" +
                "3. java uses double for manipulating numbers with higher precision if no type is specified");
    }
}
