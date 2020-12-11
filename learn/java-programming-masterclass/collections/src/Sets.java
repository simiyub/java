import data.Dog;
import data.HeavenlyBody;
import data.Moon;
import data.Planet;

import java.util.*;

public class Sets <T extends HeavenlyBody >{


    private Set<T> planets;
    private static Map<String, HeavenlyBody> solarSystem;
    public static void main(String[] args) {
        solarSystem = new HashMap<>();

        bulkOperationsExamples();

        collectionAndArrayExamples();

    }


    private static void bulkOperationsExamples() {
        /**
         * Because bulk operations are destructive, we use a new Set here.
         * */
        Dog dog = new Dog("Twinkle");

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i=1;i <=100;i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("There are "+squares.size()+ "squares and "+cubes.size()+" cubes");
        Set <Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains "+union.size() + " elements.");
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("intersection contains"+intersection );
        for(int i:intersection){
            System.out.println(i+" is the square of "+Math.sqrt(i)+" and the cube of "+Math.cbrt(i));
        }
    }

    private static void collectionAndArrayExamples() {
        /**
         * Collections working with arrays
         * */
        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] wordArray = sentence.split(" ");
        words.addAll(Arrays.asList(wordArray));
        for (String s : words){
            System.out.println(s);
        }

        Set <String> nature = new HashSet<>();
        Set <String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(divine);
        diff1.removeAll(nature);
        printSet(diff1);
        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(nature);
        diff2.removeAll(divine);
        printSet(diff2);

        Set<String> union = new HashSet<>(nature);
        union.addAll(divine);
        System.out.println("Add all");
        printSet(union);
        Set<String> intersection = new HashSet<>(nature);
        intersection.retainAll(divine);
        System.out.println("retain all");
        printSet(intersection);

        if (nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }
        if(nature.containsAll(intersection)){
            System.out.println("intersection is a subset of nature");
        }
        if(divine.containsAll(intersection)){
            System.out.println("intersection is a subset of divine");
        }

    }

    private static void printSet(Set<String> set) {
        System.out.println("\t");
        for (String s: set){
            System.out.println(s+" ");
        }
    }


    private Set<Moon> getMoons() {
        Set<Moon> moons = new HashSet<>();
        for (T planet:planets){
            moons.addAll(planet.getSatellites());
        }
        return moons;
    }

    Set<T> createPlanets() {
        createPlanet("Mercury", 22,null);
        createPlanet("Venus",225,null);
        Set<Moon> moons = new HashSet<>();
        moons.add(new Moon("Moon",27));
        createPlanet("Earth",365, moons);
        moons = new HashSet<>();
        moons.add(new Moon("Deimos", 1.3));
        moons.add(new Moon("Phobos", 8.3));
        createPlanet("Mars", 155, moons);
        moons = new HashSet<>();
        moons.add(new Moon("Io", 1.8));
        moons.add(new Moon("Europa", 3.5));
        moons.add(new Moon("Ganymede", 7.1));
        moons.add(new Moon("Callisto", 16.7));
        createPlanet("Jupiter", 4332,moons);
        createPlanet("Saturn", 10759,null);
        createPlanet("Uranus", 30660, null);
        createPlanet("Neptune", 165, null);
        createPlanet("Pluto", 248, null);
        return planets;
    }

    private Planet createPlanet(String name, float orbitalPeriod,Set<Moon> moons){
        Planet newPlanet = new Planet(name, orbitalPeriod, "planet", moons) ;
        solarSystem.put(newPlanet.getName(),newPlanet);
        planets.add((T)newPlanet);
        return newPlanet;
    }


    public Map<String, HeavenlyBody> getSolarSystem() {
        return solarSystem;
    }
}
