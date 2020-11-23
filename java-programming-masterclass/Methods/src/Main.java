public class Main {

    public static void main(String[] args) {
        int highScore = score(                true,10000, 8, 200);

        highScore=score(true, 5000,5, 100);

        int position = calculateHighScorePosition(500);
        displayHighScorePosition("george",11);
        displayHighScorePosition("player 1500",calculateHighScorePosition(1500));
        displayHighScorePosition("player 900",calculateHighScorePosition(900));
        displayHighScorePosition("player 400",calculateHighScorePosition(400));
        displayHighScorePosition("player 50",calculateHighScorePosition(50));
        double number = 5.0;
        int one = 1;




    }

    private static int calculateHighScorePosition(int score) {
        return score >= 1000? 1 : score >=500 ? 2 : score>= 100? 3 : 4;
    }

    private static void displayHighScorePosition(String name, int position) {
        System.out.println("\n"+name+" managed to get into position "+position+" on the high score table.");
    }

    private static int score(boolean gameOver, int score, int levelComplete, int bonus) {

        if (score >= 5000){
            System.out.println("Score was"+score);
        }
        else{
            System.out.println("Score was low");
        }

        if(gameOver){
            int finalScore = score +(levelComplete *bonus);
            System.out.println("Your final score was "+finalScore);
            return finalScore;
        }
        return -1;
    }
}
