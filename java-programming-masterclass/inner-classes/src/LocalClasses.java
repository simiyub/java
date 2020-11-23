
import Button.Button;

import java.util.Scanner;


/*****
 * * 3. Local class - classes that are defined in a block, which is a group of zero or more statements between balanced braces. You typically find local classes defined in the body of a method
 *
 */
public class LocalClasses {


    private static Scanner scanner;
    private static Button btnPrint;

    public static void main(String[] args) {
        btnPrint=new Button("Main");
        scanner=new Scanner(System.in);
        class  ClickListener implements Button.OnClickListener {
            public ClickListener(){
                System.out.println("Attached click listener");
            }


            @Override
            public void onClick(String title) {
                System.out.println("title clicked");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    quit=true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
                default:
                    quit=true;
                    break;
            }
        }
    }

}
