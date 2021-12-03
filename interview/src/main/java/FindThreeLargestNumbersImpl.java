import java.util.Arrays;

public class FindThreeLargestNumbersImpl implements FindThreeLargestNumbers {
    @Override
    public int[] find(int[] array) {

        int required =3;
        int[] highest =  new int[3];

        for(int i=0;i<=array.length-1;i++) if (highest[0] < array[i]) highest = shift(highest,array[i]);

        return highest;
    }

    private int[] shift(int[] highest, int value) {
        int newIndex = -1;
        for(int i=0; i<= highest.length-1;i++){
            if (newIndex>=0 && highest[i-1]<value) {
                if(highest[i] >value) break;
                highest[i-1] = highest[i];
            }
            newIndex ++;
        }
        highest[newIndex] = value;
        return highest;
    }
}
