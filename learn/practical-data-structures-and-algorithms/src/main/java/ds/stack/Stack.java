package ds.stack;

public interface Stack {
    void push(long i);
    long pop();
    long peek();
    boolean isEmpty();
    boolean isFull();
    char[] ring = {'2','1'};
}
