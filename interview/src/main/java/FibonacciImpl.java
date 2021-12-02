public class FibonacciImpl implements Fibonacci{
    @Override
    public int fibonacci(int n) {
        return fibonacciRecursive(2,n, 0, 1);
    }

    private int fibonacciRecursive(int start, int end, int secondLast, int last ) {
        if(start!=end) {
            int next = secondLast + last;
            return fibonacciRecursive(start +1, end, last, next);
        }
        return last;
    }
}
