import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        example();
        readingUserInputChallenge();
        minMaxChallenge();
        inputThenPrintSumAndAverage();
        getBucketCount(-3.4,2.1,1.5,2);
        getBucketCount(3.4,2.1,1.5,2);
        getBucketCount(2.75,3.25,2.5,1);
        getBucketCount(-3.4,2.1,1.5);
        getBucketCount(3.4,2.1,1.5);
        getBucketCount(7.25,4.3,2.35);
        getBucketCount(3.4,1.5);
        getBucketCount(6.26,2.2);
        getBucketCount(3.26,0.75);
    }

    private static int getBucketCount(double width, double height, double areaPerBucket){
        return getBucketCount(width,height,areaPerBucket,0);
    }

    private static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        int count=-1;
        if((width>0 && height>0 && areaPerBucket>0) && extraBuckets>=0){
            count=(int)getBucketCount((width*height), areaPerBucket)-extraBuckets;
        }
        return count;
    }

    private static int getBucketCount(double area, double areaPerBucket) {
        int count=-1;
        if(area>0 && areaPerBucket>0){
            count=(int)(Math.ceil(area/areaPerBucket));
        }
        return count;
    }

    private static void inputThenPrintSumAndAverage() {
        Scanner inputSource = new Scanner(System.in);
        System.out.println("This program will print out sum and average of numbers input by a user.");
        int sum = 0;
        long avg = 0;
        int count = 0;
        String numbers = "";

        while (true) {
            System.out.println("Please enter a number");
            if (inputSource.hasNextInt()) {
                count++;
                int number = inputSource.nextInt();
                sum += number;
                numbers += " " + number +",";
                System.out.println("Numbers received so far:" + numbers);
                inputSource.nextLine();
            } else {
                avg = Math.round((double) sum / count);
                break;
            }
        }
        System.out.println("SUM = " + sum + " AVG = " + avg);
        inputSource.close();
    }
    private static void minMaxChallenge() {

        System.out.println("This program will work out the minimum and maximum of values entered by the user\n");
        System.out.println("Type x to exit.");
        Scanner inputSource=new Scanner(System.in);
        boolean starting=true;
        int min=-1;
        int max=-1;
        int value = -1;
        while (true){
            System.out.println("Enter a value:");
            if(inputSource.hasNextInt()){
                value=inputSource.nextInt();

                if(starting){
                    min=value;
                    max=value;
                    starting=false;
                }
                min = value<min ? value : min;
                max = value>max ? value : max;
                inputSource.nextLine();
            }
            else if(inputSource.hasNext("x")){
                System.out.println("Exiting..");
                break;
            }
            else {
                System.out.println("Invalid input of "+inputSource.next()+" entered. Program will exit.");
                break;
            }

        }
        System.out.println("The min value received was:"+min+" and max value was:"+max);
        inputSource.close();
    }

    private static void readingUserInputChallenge() {

        System.out.println("This program will sum up 10 numbers of your choice.");
        int count=1;
        int sum=0;
        String userInput="";
        Scanner userInputSource=new Scanner(System.in);
        while(count<=10){
            System.out.println("Enter number "+count);
            int number=0;

            if(userInputSource.hasNextInt()){
                number=userInputSource.nextInt();
                userInputSource.nextLine();
                System.out.println("You typed: "+number);
                sum+=number;
                userInput+= number;
                userInput+= count!=10? " + ": " = ";
                System.out.println("Sum="+sum);
                count++;
            }
            else{
                System.out.println("Invalid Input. Try again");
                userInputSource.nextLine();
            }

        }
        System.out.println(userInput+sum);
        userInputSource.close();
    }

    private static void example() {
        //System passes input in and scanner reads the user input
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter year of your birth:");
        int age = 0;
        if(scanner.hasNextInt()){
            int yearOfBirth = scanner.nextInt();
            if(yearOfBirth>0){
                age = 2020-yearOfBirth;
            }
            else {
                System.out.println("Invalid year of birth");
            }

        }

        scanner.nextLine();//handle next line character[enter key]
        System.out.println("Enter your name");//Get user input
        String name = scanner.nextLine();

        System.out.println("User is:"+name);
        System.out.println("Your age is:"+age);

        //release resources.
        scanner.close();
    }
}
