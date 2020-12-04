import data.Dog;
import data.HeavenlyBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    private static HashMap<String, HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> planets;

    public static void main(String[] args) {
        demoHashSet();

        demoSetMethods();

        bulkOperationsExamples();

        collectionAndArrayExamples();

    }

    private static void demoSetMethods() {
        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        printBodies(planets);

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
    }

    private static void demoHashSet() {
        solarSystem = new HashMap<>();
        planets = new HashSet<>();

        createHeavenlyBodies();

        printBodies(planets);

        Set<HeavenlyBody> moons = getMoons();
        printBodies(moons);
    }

    private static Set<HeavenlyBody> getMoons() {
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet:planets){
            moons.addAll(planet.getSatellites());
        }
        return moons;
    }

    private static void printBodies(Set<HeavenlyBody> bodies) {
        for(HeavenlyBody hb:bodies){
            System.out.println(hb.toString());
        }
    }

    private static void createHeavenlyBodies() {
        createHeavenlyBody("Mercury", 88,true);
        createHeavenlyBody("Venus",225,true);
        HeavenlyBody earth = createHeavenlyBody("Earth",365,true);
        earth.addMoon(createHeavenlyBody("Moon",27,false));
        HeavenlyBody mars = createHeavenlyBody("Mars",687,  true);
        mars.addMoon(createHeavenlyBody("Deimos", 1.3,false));
        mars.addMoon(createHeavenlyBody("Phobos", 8.3,false));
        HeavenlyBody jupiter = createHeavenlyBody("Jupiter", 4332,true);
        jupiter.addMoon(createHeavenlyBody("Io", 1.8,false));
        jupiter.addMoon(createHeavenlyBody("Europa", 3.5,false));
        jupiter.addMoon(createHeavenlyBody("Ganymede", 7.1,false));
        jupiter.addMoon(createHeavenlyBody("Callisto", 16.7,false));
        createHeavenlyBody("Saturn", 10759,true);
        createHeavenlyBody("Uranus", 30660, true);
        createHeavenlyBody("Neptune", 165, true);
        createHeavenlyBody("Pluto", 248, true);
    }

    private static HeavenlyBody createHeavenlyBody(String name, double orbitalPeriod, boolean planet) {
        HeavenlyBody body = new HeavenlyBody(name,orbitalPeriod);
        if(planet){
            planets.add(body);
        }
        solarSystem.put(body.getName(),body);

        return body;
    }
}
