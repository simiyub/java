/**
 * We can create a thread by implementing the Runnable interface and providing
 * an implementation of the run method.
 * */
public class ImplementRunnableDemo implements Runnable{
    private final int counter;
    public ImplementRunnableDemo(int counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        CommonFunctionality.count(this, counter);
    }
}
