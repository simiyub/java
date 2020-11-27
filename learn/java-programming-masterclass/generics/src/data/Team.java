package data;

import java.util.ArrayList;
import java.util.List;

//Can extend class or interface or multiple interfaces
public class Team<T extends Player> implements Comparable<Team<T>>{
    private final String name;
    private int played = 0;
    private int won = 0;
    private  int lost = 0;
    private int tied = 0;
    private int points;
    private int score;
    private final List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        boolean added = false;
        if(members.contains(player)){
            System.out.println(player.getName()+" is already in the team.");
        }
        else{
            members.add(player);
            added=true;
        }
        return added;
    }

    public int numberOfPlayers(){
        return this.members.size();
    }

    public int getPoints() {
        return points;
    }


    public void addPoints(int points) {
        this.points += points;
    }

    public int getWon() {
        return won;
    }

    public void addWon() {
        this.won +=1;
    }

    public int getLost() {
        return lost;
    }

    public void addLost() {
        this.lost+=1;
    }

    public int getTied() {
        return tied;
    }

    public void addTied() {
        this.tied+=1;
    }

    public int getPlayed() {
        return played;
    }

    public void addPlayed() {
        this.played+=1;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void recordMatchResults(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if(ourScore>theirScore){
            message=" beat ";
            won++;
        }
        else if(ourScore==theirScore){
            message = " tied with ";
            tied++;
        }
        else{
            message=" lost to ";
            lost++;
        }
        played++;

        if (opponent != null) {
            System.out.println(getName()+message+opponent.getName());
            opponent.recordMatchResults(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won*2) +tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        return Integer.compare(this.ranking(), team.ranking());
    }
}
