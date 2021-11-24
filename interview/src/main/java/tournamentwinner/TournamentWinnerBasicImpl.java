package tournamentwinner;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n) T -size of competitions array and O(k) S - k being the size of the teams array
 *  First solution that comes to mind and is the most optimised I can think of is:
 *  Create a map of team:score
 * 	Walk through the array of competitions and pick results
 * 	Add every win to the map
 *  Maintain a score of the current leader and swap each time there's a new leader
 * 	At the end of the loop, return current leader
 * */
public class TournamentWinnerBasicImpl implements TournamentWinner{
    @Override
    public String tournamentWinner(String[][] matchTeams, int[] results) {

        Map<String,Integer> wins = new HashMap<>();
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
