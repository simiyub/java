/**
 * Implement a function such that given a number n >2,
 * the next number in the sequence will be the sum of the last two numbers in the sequence
 * formula: fib(n) = fib(n-1) + fib(n-2) for n> 2
 * Example: 0,1, 1, 2, 3, 5, 8 fib(7)
 * */
public interface Fibonacci {

    int fibonacci(int n);
}
