public class App {

    public static void main(String[] args) {
        System.out.println();
        //Demo extending Thread class
        new ExtendThreadDemo(10).start();

        //Demo implementing runnable
        new Thread(new ImplementRunnableDemo(10)).start();

        //Demo sleep
        int[] sleepFrequency = new int[]{10000,0};
        new Thread(new ImplementRunnableDemo(10, sleepFrequency)).start();

        sleepFrequency = new int[]{10000, 20000};
        new Thread(new ImplementRunnableDemo(10, sleepFrequency)).start();
    }
}
