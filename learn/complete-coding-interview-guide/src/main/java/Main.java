public class Main {
    public static void main(String[] args) {
        System.out.println(powerxy(2,1));
    }

    private static double powerxy(int x, int y) {
        if(y<0){
            return 0;
        } else if (y==0) {
            return 1;
        }
        else {
            return x*powerxy(x,y-1);
        }
    }

    private static double factorial(double i) {
        if(i<=2){
            return i;
        }
        return i * factorial(i-1);
    }

    private static double multiply(double x, double y){
        int result = 1;
        for(int i=1; i<=y; i++){
            result *=x;
            System.out.println(result);
        }
        return result;
    }
}
