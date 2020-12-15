package data;

import java.util.Set;

public class Asteroid extends HeavenlyBody{

    public Asteroid(String name, double orbitalPeriod, Set<HeavenlyBody> satellites) {
        super(name,orbitalPeriod,"asteroid",satellites);
    }
}
