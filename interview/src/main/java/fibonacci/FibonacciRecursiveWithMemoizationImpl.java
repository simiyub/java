package fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n) T and O(n) S for the storage in the map
 * Fibonacci implementation using recursion and memoization
 * */
public class FibonacciRecursiveWithMemoizationImpl implements Fibonacci{
    @Override
    public int fibonacci(int n) {
        return fibonacci(n, new HashMap<>());
    }

    public int fibonacci(int n, Map<Integer, Integer> memo){

        if(n == 1 || n == 0) return 0;
        else if (n == 2) return 1;
        else {
            if (memo.containsKey(n)) return memo.get(n);
            else{
                int newValue = fibonacci(n-1, memo) + fibonacci(n-2, memo);
                memo.put(n,newValue);
                return newValue;
            }
        }

    }

}
