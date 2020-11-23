 class While {
     static boolean isEvenChallenge(int number) {
        boolean even=false;
        if(number%2==0){
            even=true;
            System.out.println(number+" is even.");
        }
        return even;

    }

     static void example1() {

        int number = 4;
        int start = number;
        int finishNumber=20;
        int sum = 0;
        int count = 0;

        while(number<=finishNumber){
            boolean even=isEvenChallenge(number);

            if(!even){
                number+=1;
                continue;
            }

            sum+=number;

            number+=1;
            count+=1;

            if(count==5){
                break;
            }

        }
        System.out.println("total of first five even numbers between "+start+" and "+finishNumber+" is:"+sum);
    }


     /**
      * Adds the digits in a number if >=10
      *
      **/
     static void digitSumChallenge(int number) {

        int startingNumber=number;
        int sum=0;
        if(number>=10){
            do{

                sum+=number%10;
                number=number/10;
            }while(number%10!=0);
        }
        else{
            sum=-1;
        }
        System.out.println("sum of digits in "+startingNumber+"="+sum);

    }

     static boolean isPalindrome(int number) {
        if(number<0){
            number=number*-1;
        }


        int startingNumber=number;
        int multiple = 10;
        int reverse=0;
        int currentDigit;
        do{
            currentDigit=number%10;
            reverse=(reverse * multiple) + currentDigit;
            number=number/10;

        }while(number>0);
        System.out.println("number="+startingNumber);
        System.out.println("reverse="+reverse);
        boolean isPalindrome = (startingNumber==reverse);
        System.out.println("is palidrome="+isPalindrome);
        return isPalindrome;
    }

     static int sumFirstAndLastDigit(int number){
        if (number<0){
            System.out.println("Invalid number:"+number);
            return -1;
        }
        int num=number;
        int count=0;
        int rem;
        int first = 0;
        if(num/10 <1) {
            rem = num + num;
            System.out.println("rem=" + rem);
            return rem;
        }
        do{
            rem = num%10;
            num=num/10;
            if(count==0){
                first=rem;
            }
            count++;
            System.out.println("current="+num);
        }while (num>=10);
        System.out.println("first="+first+"current="+num);
        rem=first+num;
        System.out.println("rem="+rem);
        return rem;
    }

     static int getEvenDigitSum(int number) {
        if(number<0){
            return -1;
        }
        else{
            int sum = 0;
            int digit;
            while(number >0){
                digit = number%10;
                System.out.println("digit now="+digit);
                if(number%2==0){
                    sum+=digit;
                }
                System.out.println("sum now="+sum);
                System.out.println("number before /"+number);
                number/=10;
                System.out.println("number after /"+number);
                            }
            System.out.println("sum="+sum);
            return sum;

        }
    }


     static boolean hasSharedDigit(int number1, int number2) {

        if((number1>=10 && number1<=99) && (number2>=10 && number2<=99)){

            int digit1,digit2;

            while (number1>0){
                digit1=number1%10;
                System.out.println("number1="+number1);
                System.out.println("digit1"+digit1);
                int current2=number2;
                while (current2>0){
                    System.out.println("number2="+current2);
                    digit2=current2%10;
                    System.out.println("digit2="+digit2);
                    if(digit1==digit2){
                        System.out.println("shared="+true);
                        return true;
                    }
                    current2/=10;
                }
                number1/=10;
            }
        }
        return false;

    }



      static boolean hasSameLastdigit(int number1, int number2, int number3) {
         boolean same=false;
         if(isValidForSameLastDigit(number1) && isValidForSameLastDigit(number2) && isValidForSameLastDigit(number3)){
             if(number1%10==number2%10){
                 System.out.println(number1+" and "+number2+" have the same last digit");
                 same=true;
             }
             if(number1%10==number3%10){
                 System.out.println(number1+" and "+number3+" have the same last digit");
                 same=true;
             }
             if(number2%10==number3%10){
                 System.out.println(number2+" and "+number3+" have the same last digit");
                 same=true;
             }
         }
         return same;
     }

     static boolean isValidForSameLastDigit(int number) {
         return number>=10 && number<=1000;
     }

     static int getDigitCount(int number) {
         int count=0;
         if(number>0){
             int checker=1;
             while(checker<=number){
                 count+=1;
                 checker*=10;
                 System.out.println("count="+count);
             }
         }
         else if(number==0){
             count=1;
         }
         else{
             count=-1;
         }
         return count;
     }

     static int reverse(int received){
         int rev=0;
         int number=received;
         boolean reversed=false;
         if(number<0){
             number*=-1;
             reversed=true;
         }
          while(number>0){
              int digit = number%10;
              rev=(rev*10)+digit;

              number/=10;

          }
          if(reversed){
              rev*=-1;
          }
         System.out.println("reverse="+rev);
          return rev;

     }

     static void numberToWords(int number) {

         if (number == 0) {
             System.out.println(number + " in words is:" + "Zero");
         }
         else {
             int reversed = While.reverse(number);
             int originalDigitCount = getDigitCount(number);
             int reversedDigitCount = getDigitCount(reversed);

             System.out.println("original digit count=" + originalDigitCount);
             System.out.println("reversed digit count=" + reversedDigitCount);
             String word = "";
             int toWords = reversed;
             while (toWords > 0) {
                 int digit = toWords % 10;
                 word += digit == 0 ? " Zero"
                         : digit == 1 ? " One"
                         : digit == 2 ? " Two"
                         : digit == 3 ? " Three"
                         : digit == 4 ? " Four"
                         : digit == 5 ? " Five"
                         : digit == 6 ? " Six"
                         : digit == 7 ? " Seven"
                         : digit == 8 ? " Eight"
                         : digit == 9 ? " Nine"
                         : "Invalid Value";
                 toWords /= 10;
             }
             for (int i = 0; i < (originalDigitCount - reversedDigitCount); i++) {
                 word += " Zero";
             }

             System.out.println(number + " in words is:" + word);

         }
     }

 }
