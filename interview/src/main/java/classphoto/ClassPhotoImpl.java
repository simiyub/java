package classphoto;

import java.util.Arrays;

/**
 * O(nlogn) T O(1) S with an iteration through the arrays jointly.
 * As such O(nlogn).
 * How it works:
 * -------------
 * Greedy algorithm
 * We sort the arrays so we can compare the arrays jointly.
 * Then we check if the conditions for the photo are met. Soon we find a conflict, we exit.
 * */
public class ClassPhotoImpl implements ClassPhoto {
    @Override
    public boolean feasible(int[] jumper, int[] noJumper) {
        Arrays.sort(jumper);
        Arrays.sort(noJumper);

        boolean jumperFront = jumper[0] < noJumper[0] ;

        for (int i = 0; i <= jumper.length - 1; i++) {
            if (jumperFront) {
                if(noJumper[i]<=jumper[i]) return false;
            }
            else{
                if(jumper[i] <= noJumper[i]) return false;
            }
        }
        return true;
    }

}
