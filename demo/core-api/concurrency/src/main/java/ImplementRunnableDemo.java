/**
 * We can create a thread by implementing the Runnable interface and providing
 * an implementation of the run method.
 * */
public class ImplementRunnableDemo implements Runnable{
    private final int counter;
    private int sleepFrequency=0;
    private int extraSleepFrequency=0;
    public ImplementRunnableDemo(int counter){
        this.counter = counter;
    }

    public ImplementRunnableDemo(int counter, int[] sleepFrequency) {
        this.counter = counter;
        this.sleepFrequency = sleepFrequency[0];
        this.extraSleepFrequency = sleepFrequency[1];
    }

    /**
     * In sleeping for a period of time, the thread can allow other threads to process
     * and can also be used to pace processing allowing what it has generated to be processed first.
     * In this implementation, the thread sleeps for time of sleepFrequency
     * We also make use of the overloaded implementation of sleep,
     * allowing the thread to sleep for extra time if provided.
     * */
    private void sleepDemo() {

        {
            try {
                if(extraSleepFrequency>0) Thread.sleep(sleepFrequency, extraSleepFrequency);
                else Thread.sleep(sleepFrequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("slept for %s seconds and %s nanoseconds %s",
                    sleepFrequency/1000,extraSleepFrequency,".. exiting now.");
        }
    }

    @Override
    public void run() {
        CommonFunctionality.count(this, counter);
        if(sleepFrequency!=0)sleepDemo();
    }


}
