import java.lang.reflect.Array;
import java.util.Arrays;

public class StackDemo<E>{
    E[] stack;
    int top;
    
    StackDemo(int size){
        stack = (E[]) Array.newInstance(Object[].class.getComponentType(),size);
        top = 0;

    }

    public E push(E e) {
        ensureCapacity();
        stack[top++] = (E) e;
        return (E) stack[top-1];
    }

    public E pop() {
        E e = (E) stack[--top];
        stack[top] = null;
        return e;
    }

    public E peek() {
        return top == 0 ? null : (E) stack[top-1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        System.out.println(stack[0]);
        return top == 0;
    }

    public boolean isFull() {
        return top >= stack.length;
    }

    public int ensureCapacity() {

        if(size() != 0 && size()/stack.length > 0.5) stack = Arrays.copyOf(stack,stack.length*2);
        return stack.length;
    }
}
