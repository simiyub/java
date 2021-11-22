public class Concurrency {
    private static Thread thread1,thread2;
    public static void main(String[] args) {


        Runnable runnable2 = ()  ->{
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException exception){
                System.out.println("interrupted runnable 2");
                exception.printStackTrace();
            }
            System.out.println("state of joined thread:"+thread1.getState());
        };

        Runnable runnable1 = () -> {

            Thread thread2 = new Thread(runnable2);
            thread2.start();
            printState(thread2);

            try{
                thread2.join();
                Thread.sleep(2000);
            }
            catch (InterruptedException exception){
                System.out.println("interrupted runnable 1");
                Thread.currentThread().interrupt();
                exception.printStackTrace();
            }


        };

        Runnable runnableTimedWaiting = () -> {

            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException exception){
                System.out.println("interrupted runnable 1");
                Thread.currentThread().interrupt();
                exception.printStackTrace();
            }


        };

        Runnable runnableTerminated = () -> {

            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException exception){
                System.out.println("interrupted");
                Thread.currentThread().interrupt();
                exception.printStackTrace();
            }


        };


        thread1 = new Thread(runnable1);
        printState(thread1);
        thread1.start();
        printState(thread1);




        try{
            Thread.sleep(2500);

            //Timed waiting
            Thread thread3 = new Thread(runnableTimedWaiting);
            printState(thread3);

            Thread threadTerminated = new Thread(runnableTerminated);
            printState(threadTerminated);

        }
        catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
        printState(thread1);

    }

    private static void printState(Thread thread) {
        System.out.println(thread.getName()+thread.getState());
    }


}
