import java.util.HashMap;
import java.util.Map;

/**
 * O(2^n) T as each recursion calls a multiple of fib and O(n) S
 * for the stack waiting for response from the fib calls
 * Fibonacci implementation using recursion naively
 * */
public class FibonacciRecursiveImpl implements Fibonacci{
    @Override
    public int fibonacci(int n) {
        if(n == 1 || n == 0) return 0;
        else if (n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

}
