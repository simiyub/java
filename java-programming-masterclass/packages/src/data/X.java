package data;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *         // Write a small program to read an integer from the keyboard
 *         // (using Scanner) and print out the times table for that number.
 *         // The table should run from 1 to 12.
 *         //
 *         // You are allowed to use one variable called scanner for your
 *         // Scanner instance. You can use as many other variables as you
 *         // need, but they must must all be called x. That includes any
 *         // class instances and loop control variables that you may decide
 *         // to use.
 *         //
 *         // If you use a class, the class can be called X (capital), but
 *         // any instances of it must be called x (lower case).
 *         //
 *         // Any methods you create must also be called x.
 *         //
 *         // Optional Extra:
 *         // Change your program so that ALL variables (including the scanner
 *         // instance) are called x.
 *
 * */

public class X {

    static Scanner x;
    public static void x() {
        x = new Scanner(System.in);
        boolean more = true;
        while(more){
            System.out.println("Please enter a number to see the times table, 0 to Exit");
            int input = x.nextInt();
            if(input==0){
                System.out.println("Exiting");
                more=false;
            }
            else{
                for(int x=1; x<=12;x++){
                    System.out.println(x+"X"+input+"="+x*input);
                }
            }

        }

    }

}
