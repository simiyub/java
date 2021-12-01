package tandembicycle;

import java.util.Arrays;

/***
 * O(nlogn) T O(1) S
 * First we sort the arrays so we have the speeds in order
 * Determine if we are looking for fastest total speed or lowest
 * We iterate through one of the arrays checking:
 * If we are looking for fastest speed:
 * we determine the higher of the two speeds between the highest and the lowest speeds in the arrays
 * else we determine the lower of the two speeds between the corresponding speeds in the sorted arrays.
 * */

public class TandemBicycleImpl implements TandemBicycle{

    private int higher(int first,int second ){
        return first > second ? first : second;
    }

    @Override
    public int speed(int[] teamA, int[] teamB, boolean fastest) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        int speed = 0;
        int highIndex = teamA.length-1;
        for(int i=0;i<=teamA.length-1;i++){

            speed += (fastest) ? higher(teamA[i] , teamB[highIndex-i]) : higher(teamA[i] , teamB[i]);
        }
        return speed;

    }
}
