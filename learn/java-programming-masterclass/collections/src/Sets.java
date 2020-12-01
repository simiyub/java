import data.HeavenlyBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    private static HashMap<String, HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> planets;

    public static void main(String[] args) {
        HeavenlyBody heavenlyBody = new HeavenlyBody("mars",1.2);
        solarSystem = new HashMap<>();
        planets = new HashSet<>();
        createHeavenlyBody("Mercury", 88,null);
        createHeavenlyBody("Venus",225,null);
        HeavenlyBody earthMoon = createHeavenlyBody("Moon",27,null);
        createHeavenlyBody("Earth",365,earthMoon);


    }

    private static HeavenlyBody createHeavenlyBody(String name, int orbitalPeriod, HeavenlyBody moon) {
        HeavenlyBody body = new HeavenlyBody(name,orbitalPeriod);
        if(moon!=null){
            body.addMoon(moon);
        }
        solarSystem.put(body.getName(),body);
        planets.add(body);
        return body;
    }
}
