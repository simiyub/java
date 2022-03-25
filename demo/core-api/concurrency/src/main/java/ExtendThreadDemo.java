
/**
 * We can create a thread by extending the thread class, which extends the Runnable interface.
 * It has a run method which does nothing if we created a thread using this extension option.
 * Therefore, your subclass should implement run.
 * In our example, the run method takes an integer and counts from 1 to the integer provided.
 *
 * */


public class ExtendThreadDemo extends Thread{
    private final int counter;

    public ExtendThreadDemo(int counter){
        this.counter = counter;
    }

    public void run(){
        CommonFunctionality.count(this, counter);
    }


}
