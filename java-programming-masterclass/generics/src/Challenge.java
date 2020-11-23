
import data.FootballTeam;
import data.League;


/**
 *  Create a generic class to implement a league table for a sport.
 *  The class should allow teams to be added to the list, and store
 *  a list of teams that belong to the league.
 *
 *  Your class should have a method to print out the teams in order,
 *  with the team at the top of the league printed first.
 *
 *  Only teams of the same type should be added to any particular
 *  instance of the league class - the program should fail to compile
 *  if an attempt is made to add an incompatible team.
 *
 * ================
 * Tweaked my solution a bit to suit UK football.
 * Future feature: record of teams a team has beaten, lost to and drawn with
 * Really cool feature I had to try hard to resist doing it for fun: ranking teams: by points, then goal difference, then count of matches won, then who beat the other team more times, then by name.
 * Also to record goals conceded,list of teams the team has beaten and teams it has lost to
 * */



public class Challenge {
    public static void main(String[] args) {

        League league = new League("First", "Football", 2020,5);
        FootballTeam team1=new FootballTeam("Team 1");
        FootballTeam team2=new FootballTeam("Team 2");
        FootballTeam team3=new FootballTeam("Team 3");
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.standing();
        league.recordMatchResults(team1,team2,3,2);
        league.recordMatchResults(team2,team1,3,2);
        league.recordMatchResults(team1,team3,2,4);
        league.recordMatchResults(team3,team1,3,1);
        league.recordMatchResults(team2,team3,4,2);
        league.recordMatchResults(team3,team2,3,1);
    }

}
