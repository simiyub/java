public class App {
    public static void main(String[] args) {

        parsingExamples();
        canPack(2,0,9);//false
        canPack(1,0,4); //false
        canPack(1,0,5); //true
        canPack(0,5,4); //true
        canPack(2,2,11); //true
        canPack(-3,2,11); //false
        canPack(4,18,19); //true
        canPack(5,3,24); //false
        getLargestPrime(21);//7
        getLargestPrime(217);//31
        getLargestPrime(0);//-1
        getLargestPrime(45);//5
        getLargestPrime(-1);//-1
        getLargestPrime(1147);//37
        getLargestPrime(7);//7
        getLargestPrime(31);//31
        printSquareStar(5);

    }

    private static void printSquareStar(int number) {
        if(number>=5){

            String star = "*";
            String space=" ";
            for(int rowCount=1;rowCount<=number;rowCount++) {

                for(int columnCount=1;columnCount<=number;columnCount++){
                    if(rowCount==1||rowCount==number){
                        System.out.print(star);
                    }
                    else if((rowCount!=1 && rowCount!=number) && (columnCount==1 || columnCount==number )){
                        System.out.print(star);
                    }
                    else if (rowCount==columnCount){
                        System.out.print(star);
                    }
                    else if(columnCount==(number-rowCount)+1){
                        System.out.print(star);

                    }
                    else {
                        System.out.print(space);
                    }
                }
                System.out.println();
                }
        }
        else{
            System.out.println("Invalid Value");
        }

    }

    private static int getLargestPrime(int number) {
        int largestPrime = -1;
        if(number==2 || number==3 || number==5 || number==7){

            largestPrime=number;
        }
        else {
            for (int i = 2; i <= number; i++) {
                if ((i == 2 || i == 3 || i == 5 || i == 7) || (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0)) {

                    if (number % i == 0) {
                        if (largestPrime == -1 && i == number) {
                            largestPrime = number;
                        }
                        else if(i!=number){
                            largestPrime = i;
                        }

                    }
                }
            }
        }

        System.out.println("prime divisor:"+largestPrime);
        return largestPrime;
    }

    private static boolean canPack(int bigCount, int smallCount, int goal){
        boolean can=false;
        if(bigCount>=0 && smallCount>=0 && goal>=0){
            int bigKg=5;
            int smallKg=1;
            if(bigCount*bigKg==goal||smallCount*smallKg==goal){
                System.out.println("goal reached");
                can=true;
            }
            else{
                for(int i=0;i<=bigCount;i++){

                    for (int j=0;j<=smallCount;j++){
                        int bigWeight=i*bigKg;
                        int smallWeight=j*smallKg;
                        if( bigWeight + smallWeight==goal){
                            System.out.println("Goal="+goal);
                            System.out.println("[bigCount="+bigCount+"smallCount="+smallCount);
                            System.out.println("[bigWeight="+bigWeight+"smallWeight="+smallWeight);
                            System.out.println("goal reached");
                            return true;
                        }
                    }
                }
            }

        }
        return can;
    }

    private static void parsingExamples() {

        String numberAsString = "100";
        System.out.println(numberAsString);

        //Using parsing throws NumberFormatException if not a valid number.
        int number=Integer.parseInt(numberAsString);
        System.out.println("100+10="+(number+10));

        double numberAsDouble=Double.parseDouble(numberAsString);
        System.out.println("100 as double="+numberAsDouble);
    }
}
