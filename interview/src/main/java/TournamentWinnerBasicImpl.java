public class TournamentWinnerBasicImpl implements TournamentWinner{
    @Override
    public String tournamentWinner(String[][] matchTeams, int[] results) {
        String winner = null;
        for(int i=0;i<matchTeams.length;i++){
            winner = results[i] == 1 ? matchTeams[0][0] : matchTeams[0][1];
        }
        return winner;
    }
}
