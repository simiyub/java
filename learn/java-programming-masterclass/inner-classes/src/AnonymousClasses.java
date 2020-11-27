import Button.Button;

import java.util.Scanner;

public class AnonymousClasses {

    private static Scanner scanner;
    private static Button btnPrint;

    public static void main(String[] args) {

        btnPrint = new Button("Main");
        scanner = new Scanner(System.in);
        btnPrint.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(String title) {
                System.out.println(title + "was clicked anonymously");
            }

        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
                default:
                    quit = true;
                    break;
            }

        }
    }
}
