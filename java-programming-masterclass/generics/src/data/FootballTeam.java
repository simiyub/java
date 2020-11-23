package data;

public class FootballTeam extends Team {

    public FootballTeam(String name) {
        super(name);
    }


    @Override
    public int compareTo(Team team) {
        //compare teams based on points.
        return Integer.compare(this.getPoints(), team.getPoints());

    }
}
