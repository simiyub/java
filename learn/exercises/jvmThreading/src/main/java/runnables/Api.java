package runnables;

public class Counter {
    public static void main(String[] args) {
        Runnable r = () ->{
            for(int i=0;i<100_000;i++){
                count++;
            }
            System.out.println();
        }
    }
}
