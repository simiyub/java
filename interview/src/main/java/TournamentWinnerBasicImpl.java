import java.util.HashMap;
import java.util.Map;

public class TournamentWinnerBasicImpl implements TournamentWinner{
    @Override
    public String tournamentWinner(String[][] matchTeams, int[] results) {

        Map<String,Integer> wins = new HashMap();
        String currentLeader = null;

        for(int i=0;i<=matchTeams.length-1;i++){
            String winner = results[i] == 1 ? matchTeams[i][0] : matchTeams[i][1];
            int currentPoints = wins.getOrDefault(winner, -1);
            int points = 3;
            if (currentPoints != -1) {
                points += currentPoints;
                wins.replace(winner,points);

            }
            else{
                wins.put(winner, points);
            }
            if (points > wins.getOrDefault(currentLeader,-1)) currentLeader = winner;
        }

        return currentLeader;
    }
}
