public class App {

    public static void main(String[] args) {
        System.out.println();
        //Demo extending Thread class
        new ExtendThreadDemo(10).start();

        //Demo implementing runnable
        new Thread(new ImplementRunnableDemo(10)).start();
    }
}
