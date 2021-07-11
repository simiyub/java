package easy;

public class Recursion {
    static int[] fib;
    public static int[] run(int n) {
        fib = new int[n];
        for(int i=0;i<n;i++){
            fib[i] = fibonacci(i);
        }
        return fib;

    }

    public static int fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        else if(n ==1){
            return  1;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
