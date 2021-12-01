import java.util.Arrays;

public class TandemBicycleImpl implements TandemBicycle{

    private int higher(int first,int second ){
        return first > second ? first : second;
    }
    private int lower(int first, int second){
        return first < second ? first : second;
    }
    @Override
    public int speed(int[] teamA, int[] teamB, boolean fastest) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        int speed = 0;
        int highIndex = teamA.length-1;
        for(int i=0;i<=teamA.length-1;i++){

            speed += (fastest) ? higher(teamA[i] , teamB[highIndex-i]) : lower(teamA[i] , teamB[i]);
        }
        return speed;

    }
}
