package data;

import java.util.*;

public class League <T extends Team> {
    private final String name;
    private final String sport;
    private final int yearEstablished;
    private final int numberOfTeams;
    private final List<T> teams;
    private final List<T> standing;

    public League(String name, String sport, int yearEstablished, int numberOfTeams) {
        this.name=name;
        this.sport=sport;
        this.yearEstablished = yearEstablished;
        this.numberOfTeams = numberOfTeams;
        this.teams=new ArrayList<>();
        this.standing=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void addTeam(T footballTeam) {
        this.teams.add(footballTeam);
    }

    private void updateStanding() {

        Collections.sort(this.teams,Collections.reverseOrder());
    }

    public void standing() {
        System.out.println("As it stands..");
        System.out.println("Team   Played Won Lost Drawn Goals Points");
        for(T team:this.teams){
            System.out.println(team.getName()+"   "+team.getPlayed()+"     "+team.getWon()+"   "+team.getLost()+"     "+team.getTied()+"     "+team.getScore()+"      "+team.getPoints());
        }
    }

    public void recordMatchResults(T homeTeam, T awayTeam, int homeTeamScore, int awayTeamScore) {
        //update points of both teams.
        T updatedHomeTeam = this.teams.remove(this.teams.indexOf(homeTeam));
        T updatedAwayTeam = this.teams.remove(this.teams.indexOf(awayTeam));

        if(updatedHomeTeam!=null && updatedAwayTeam!=null){
            if(homeTeamScore>awayTeamScore) {
                updatedHomeTeam.addWon();
                updatedAwayTeam.addLost();
                updatedHomeTeam.addPlayed();
                updatedAwayTeam.addPlayed();
                updatedHomeTeam.addScore(homeTeamScore);
                updatedAwayTeam.addScore(awayTeamScore);
                updatedHomeTeam.addPoints(3);
            }
                else if(awayTeamScore>homeTeamScore) {
                updatedAwayTeam.addWon();
                updatedHomeTeam.addLost();
                updatedHomeTeam.addPlayed();
                updatedAwayTeam.addPlayed();
                updatedHomeTeam.addScore(homeTeamScore);
                updatedAwayTeam.addScore(awayTeamScore);
                updatedAwayTeam.addPoints(3);
            }
                else {
                    updatedAwayTeam.addTied();
                    updatedHomeTeam.addTied();
                    updatedHomeTeam.addPlayed();
                    updatedAwayTeam.addPlayed();
                    updatedHomeTeam.addScore(homeTeamScore);
                    updatedAwayTeam.addScore(awayTeamScore);
                    updatedAwayTeam.addPoints(1);
                    updatedHomeTeam.addPoints(1);
                }
                this.teams.add(updatedAwayTeam);
                this.teams.add(updatedHomeTeam);
                updateStanding();
                standing();
        }

    }



}
