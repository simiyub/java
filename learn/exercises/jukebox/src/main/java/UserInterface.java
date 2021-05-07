import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private static Scanner userSelection;
    private static Scanner songChoice;
    private static Map userOptions;
    private static Jukebox jukebox;

    public UserInterface(){
        userOptions = new HashMap();
        userOptions.put(1, "Play");
        userOptions.put(2, "Replay song");
        userOptions.put(3,"Play next song");
        userOptions.put(4, "Shuffle");
        userOptions.put(5, "Play specific song");
        userOptions.put(6,"Exit.");
        jukebox = new JukeBoxImpl();
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        userSelection = new Scanner(System.in);
        boolean run = true;
        while(run){
            ui.printChoices();
            int choice = userSelection.nextInt();
            if(choice==6){
                run=false;
            }
            else{
                if (userOptions.containsKey(choice)) {
                    run = ui.actionChoice(choice);
                } else {
                    ui.printInvalidInput(choice);
                }
            }

        }


    }

    private void printInvalidInput(int choice) {
        System.out.println("Invalid choice:"+choice);
    }

    private boolean actionChoice(int choice) {
        boolean actioned = false;
        switch (choice){
            case 1:
                actioned = play();
                break;
            case 2:
                actioned = previousSong();
                break;
            case 3:
                actioned = nextSong();
                break;
            case 4:
                actioned = shuffle();
                break;
            case 5:
                actioned = playThisSong();
                break;
            default:
                System.out.println("invalid choice "+choice);

        }
        return actioned;
    }

    private boolean previousSong() {
        return jukebox.previousSong()!=-1;
    }

    private boolean shuffle() {
        return jukebox.shuffle()!=-1;

    }

    private boolean playThisSong() {
       if(songChoice == null){
           songChoice = new Scanner(System.in);
       }
        System.out.println("What song would you like to play?");
        String choice = songChoice.nextLine();
        return jukebox.playSong(choice)!=-1;

    }

    private boolean nextSong() {
        return jukebox.nextSong() !=-1;
    }

    private boolean play() {
        return jukebox.play()!=-1;
    }

    private  void printChoices() {
        System.out.println("Please choose what you want from list below:\n");
        userOptions.forEach((key, value) -> System.out.println(key+"-"+value));
    }

}
