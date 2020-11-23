public class Main {
    public static void main(String[] args) {

        byteShortIntLongPrimitive();

        casting();

        challenge();
    }

    private static void challenge() {
        byte challengeByte = -127;
        short challengeShort = 32766;
        int challengeInt = 2100000000;
        long intByteShort = 50000L + 10L * (challengeByte + challengeShort + challengeInt);
        System.out.println("challenge result:50000L + 10L * (-127 + 32766 + 2147483646) = "+intByteShort);
    }

    private static void casting() {
        int minIntValue = Integer.MIN_VALUE;
        short bigShortLiteraValue = 32767;
        int total = (minIntValue/2);

        //this doesn't work as result is int. Casting does it
        //byte newByte = minIntValue/2;

        //casting int to byte
        byte newByte = (byte)(minIntValue/2);
        System.out.println("int cast to byte:"+newByte);

        //casting int to short
        short newShort = (short)(minIntValue/2);
        System.out.println("int cast to short:"+newShort);
    }

    private static void byteShortIntLongPrimitive() {
        //32 bits of memory
        int value = 10000;
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer minimum value:"+minIntValue);
        System.out.println("Integer maximum value:"+maxIntValue);
        System.out.println("Overflow when we add to max value="+(maxIntValue+1));
        System.out.println("Underflow min we subtract value="+(minIntValue-1));

        //8 bits of memory
        byte minByteValue = Byte.MIN_VALUE;
        byte maxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte min value = "+minByteValue);
        System.out.println("Byte max value = "+maxByteValue);

        //16 bits of memory
        short minShortValue = Short.MIN_VALUE;
        short maxShortValue = Short.MAX_VALUE;
        System.out.println("Short min value = "+minShortValue);
        System.out.println("Short max value = "+maxShortValue);

        long myLongValue = 100L;
        long minLongValue = Long.MIN_VALUE;
        long maxLongValue = Long.MAX_VALUE;
        System.out.println("Long min value = "+minLongValue);
        System.out.println("Long max value = "+maxLongValue);
    }


}
