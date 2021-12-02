package fibonacci;

/**
 * O(n) T O(1) S
 * Using iteration we go through the while loop once to the nth number
 *
 * * */
public class FibonacciIterativeImpl implements Fibonacci {
        @Override
        public int fibonacci(int n) {
            if (n == 1) return 0;
            return fibonacciIterative(3,n, 0,1);
        }

    private static int fibonacciIterative(int start, int end, int secondLast, int last) {

        while(start<=end) {
            int next = secondLast + last;
            secondLast = last;
            last = next;
            start ++;
        }
        return last;
    }


}
