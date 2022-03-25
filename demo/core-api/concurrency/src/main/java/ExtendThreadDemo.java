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
        count();
    }

    public void count(){
        if (counter>=0) for(int i=0;i<=counter;i++)  System.out.println(i);
    }

    public static void main(String[] args) {
        ExtendThreadDemo threadDemo = new ExtendThreadDemo(10);
        threadDemo.start();

    }
}
