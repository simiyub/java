public class TournamentWinnerBasicImpl implements TournamentWinner{
    @Override
    public String tournamentWinner(String[][] matchTeams, int[] results) {
        return matchTeams[0][0];
    }
}
