public class Main {

    public static void main(String[] args) {
        codeBlock();
        int score = 10000;
        int levelComplete = 8;
        int bonus = 200;

        if (score >= 5000){
            System.out.println("Score was"+score);
        }
        else{
            System.out.println("Score was low");
        }

        boolean gameOver=true;
        if(gameOver){
            int finalScore = score +(levelComplete *bonus);
            System.out.println("Your final score was "+finalScore);
        }
    }

    private static void codeBlock() {
        boolean gameOver = true;
        int score = 5000;
        int levelComplete = 5;
        int bonus = 100;
        if (score >= 5000){
            System.out.println("Score was"+score);
        }
        else{
            System.out.println("Score was low");
        }

        if(gameOver){
            int finalScore = score +(levelComplete *bonus);
            System.out.println("Your final score was "+finalScore);
        }
    }
}
