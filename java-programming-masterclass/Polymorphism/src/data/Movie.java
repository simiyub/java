package data;

public class Movie {

    private String name;

    public Movie(String name){

    }
    public String plot() {
        return "No plot";
    }
    public static Movie randomMovie(){
        int randomMovie=(int)(Math.random()*5)+1;
        System.out.println("Random number was");

        //
        switch(randomMovie){
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
        }
        return null;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("data.Jaws");
    }
    @Override
    public String plot(){
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay(){
        super("Independence Day");
    }
    @Override
    public String plot(){
        return "Aliens attempt to take over planet earth.";
    }
}

class MazeRunner extends Movie{
    public MazeRunner(){
        super("Maze runner");
    }
    @Override
    public String plot(){
        return "Kids try to escape a maze.";
    }
}

class StarWars extends Movie{
    public StarWars (){
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces try to take over the universe.";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("data.Forgetable");
    }
}
