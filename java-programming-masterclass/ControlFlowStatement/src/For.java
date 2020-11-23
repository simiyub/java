 class For {
     static void miniChallenge1() {
        for(int i=8; i>=2 ;i--){
            double interest = calculateInterest(10000,i);
            System.out.println("simple interest for 10000 at "+i+"%= "+interest);
        }
    }

     static void miniChallenge2() {

        int primeCount = 0;
        for(int i=0; i<=50; i++){
            if (isPrime(i)){
                System.out.println(i+" is prime");
                primeCount++;
                if (primeCount==3){
                    break;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        if(n ==1){
            return false;
        }

        for(int i=2; i<=n/2; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

     private static double calculateInterest(double amount, double rate) {
        return amount * rate/100;
    }

     static void loopWithFor() {

        for (int i=2;i<=8;i++){
            double interest = For.calculateInterest(10000,i);
            System.out.println("simple interest for 10000 at "+i+"%= "+interest);
        }
    }

     static void loopWithoutFor() {

        double interest2 = For.calculateInterest(10000,2);
        double interest3 = For.calculateInterest(10000,3);
        double interest4 = For.calculateInterest(10000,4);
        double interest5 = For.calculateInterest(10000,5);
        System.out.println("simple interest for 10000 at 2% = "+interest2);
        System.out.println("simple interest for 10000 at 3% = "+interest3);
        System.out.println("simple interest for 10000 at 4% = "+interest4);
        System.out.println("simple interest for 10000 at 5% = "+interest5);
    }

     static void sum3And5Challenge() {
        int count = 0;
        int sum=0;
        for(int i=1;i<=1000;i++){

            if(i%3==0 && i%5==0){
                count +=1;
                sum +=i;
                System.out.println(i+" is divisible by 3 and 5");
                System.out.println("Sum of first five numbers divisible by 3 and 5 is now:"+sum );

            }
            if (count==5){
                break;
            }
        }
        System.out.println("Sum of first "+count+" numbers divisible by 3 and 5 is:"+sum);
    }

    static int getGreatestCommonDivisor(int first, int second) {
        int greatestDivisor=1;
        if(first>=10 && second>=10){
            for (int i=2;i<=first;i++){

                if(first%i==0 && second%i==0){
                    System.out.println("greatest divisor is now "+greatestDivisor);
                    greatestDivisor=i;
                }
            }
        }
        else{
            greatestDivisor=-1;
        }
        System.out.println("Greatest common divisor of "+first +" and "+second+" is:"+greatestDivisor);
        return greatestDivisor;
    }

     static void printFactors(int number) {
        if (number > 1) {
            String numbers = " ";
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    numbers += (i + " ");
                }
            }
            System.out.println("Factors of " + number + "=" + numbers);
        }
        else{
            System.out.println("Invalid Value");
        }
    }

     static boolean isPerfectNumber(int number) {
         boolean perfect=false;
         if(number>=1){
             int sum=0;
             for(int i=1;i<number;i++){
                 if(number%i==0){
                     sum+=i;
                     System.out.println("sum of divisors now="+sum);
                 }
             }
             System.out.println("sum of divisors for "+number+"="+sum);
             perfect = number==sum;
             String perfectOrNot = perfect? "":" not";
             System.out.println(number+" is"+perfectOrNot+" a perfect number.");
         }

         return perfect;
     }
 }
