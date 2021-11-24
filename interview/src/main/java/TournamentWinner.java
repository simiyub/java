
/**
 * This is a function to workout the winner of a tournament given an array of team pairs for every match
 * and an array of results corresponding to the match.
 * The team pairs are in the order of [homeTeam, awayTeam]
 * The results are binary: 0 - lost, 1- Winner. So a [1, 0] means the home team won.
 * The winning team is awarded 3 points and the loser has 0 points. There are no ties.
 * There will always be at least a match and a result in each tournament.
 * Each team will get to play the other teams once.
 * Return a string which is the name of the team which won most matches.
 * */
public interface TournamentWinner {
    String tournamentWinner(String[][] matchTeams, int[] results );
}
