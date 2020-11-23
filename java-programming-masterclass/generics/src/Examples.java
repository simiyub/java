import data.BaseballPlayer;
import data.FootballPlayer;
import data.SoccerPlayer;
import data.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        exampleUnsafe();
        exampleSafe();
        exampleCustom();
    }

    private static void exampleCustom() {
        FootballPlayer footballPlayer = new FootballPlayer("footballPlayer");
        BaseballPlayer baseballPlayer = new BaseballPlayer("baseballPlayer");
        SoccerPlayer soccerPlayer = new SoccerPlayer("soccerPLayer");
        Team<FootballPlayer> footballTeamA = new Team<>("Football Team A");
        footballTeamA.addPlayer(footballPlayer);
        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");
        baseballTeam.addPlayer(baseballPlayer);
        Team<SoccerPlayer> soccerTeam = new Team<>("Soccer Team");
        soccerTeam.addPlayer(soccerPlayer);
        System.out.println(soccerTeam.numberOfPlayers());
        //This will not work: soccerTeam.addPlayer(baseballPlayer);
        //But this means the team is made up of players from different sports.
        //Let's change the types
        Team<FootballPlayer> footballTeamB = new Team<>("Football Team B");
        footballTeamA.recordMatchResults(footballTeamB,1,1);

        Team<FootballPlayer> footballTeamC = new Team<>("Football Team C");
        footballTeamC.recordMatchResults(footballTeamB,2,1);
        System.out.println("Rankings");
        System.out.println(footballTeamA.getName()+":"+footballTeamA.ranking());
        System.out.println(footballTeamB.getName()+":"+footballTeamB.ranking());
        System.out.println(footballTeamC.getName()+":"+footballTeamC.ranking());

        System.out.println(footballTeamA.compareTo(footballTeamB));
        System.out.println(footballTeamB.compareTo(footballTeamC));
    }

    private static void exampleSafe() {

        List<Integer> multiplied = arrayMultiplied(getSafeArray(), 3);
        System.out.println(multiplied.toString());
        //multiplied.add("This is a problem as this is intended to be a list of integers");
        //This would fail as array can only contain integers:
    }

    private static void exampleUnsafe() {

       List<Integer> multiplied = arrayMultiplied(getUnsafeArray(), 2);
        System.out.println(multiplied.toString());
       // multiplied.add("This is a problem as this is intended to be a list of integers");
       // arrayMultiplied(multiplied,3); // This will fail as function expects to multiply integers.
        System.out.println(multiplied.toString());
    }

    private static List<Integer> getUnsafeArray() {
        ArrayList fromEmpty = new ArrayList<>();
        fromEmpty.add(1);
        System.out.println(fromEmpty.toString());
        ArrayList arraysAsList = new ArrayList<>(Arrays.asList(2,3,4));
        ArrayList listOf = new ArrayList<>(List.of(5,6,7));
        fromEmpty.addAll(arraysAsList);
        fromEmpty.addAll(listOf);
        ArrayList listFromList = new ArrayList<>(fromEmpty);

        System.out.println(arraysAsList.toString());
        System.out.println(listOf.toString());
        System.out.println(fromEmpty.toString());
        System.out.println(listFromList.toString());
        return listFromList;
    }

    private static List<Integer> getSafeArray() {
        ArrayList<Integer> fromEmpty = new ArrayList<>();
        fromEmpty.add(1);
        System.out.println(fromEmpty.toString());
        ArrayList<Integer> arraysAsList = new ArrayList<>(Arrays.asList(2,3,4));
        ArrayList<Integer> listOf = new ArrayList<>(List.of(5,6,7));
        fromEmpty.addAll(arraysAsList);
        fromEmpty.addAll(listOf);
        ArrayList<Integer> listFromList = new ArrayList<>(fromEmpty);

        System.out.println(arraysAsList.toString());
        System.out.println(listOf.toString());
        System.out.println(fromEmpty.toString());
        System.out.println(listFromList.toString());
        return listFromList;
    }
    private static List<Integer> arrayMultiplied(List<Integer> array,int multiplier){
        List<Integer> multiples = new ArrayList<>();
        for (int number: array){
            multiples.add(number*multiplier);
        }
        return multiples;
    }
}
