package utils;

import java.util.Arrays;
import java.util.Random;

public class Util {

    public static Integer[] getArray(int size, int upperLimit) {
        Random random = new Random();
        Integer[] integers = new Integer[size];
        for(int i=0;i<size;i++){
            integers[i] = random.nextInt(upperLimit);
        }
        System.out.println(Arrays.toString(integers));
        return integers;
    }
}
