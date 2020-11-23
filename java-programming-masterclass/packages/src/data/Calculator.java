package data;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static int nSum(int n) {
        int sum = 0;
        for (int i=0; i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i=1;i<=n;i++) {
            fact*=i;
        }
        return fact;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else {


            if (n < 3) {
                return 1;
            }
            else {
                List<Integer> numbers = new ArrayList<>(List.of(0,1,1));
                int current=0;

                for (int i = 3; i <= n; i++) {
                    current =  numbers.get(i-1)+numbers.get(i-2);
                    numbers.add(current);
                }
                return current;

            }
        }
    }
}
