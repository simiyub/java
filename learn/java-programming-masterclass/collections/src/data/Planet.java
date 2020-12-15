package data;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody {
    private final String name = null;
    private final double orbitalPeriod = 0;
    private final String bodyType = null;
    private Set<Moon> satellites;

    public Planet(String name, double orbitalPeriod, Set<Moon> satellites) {
        super(name,orbitalPeriod,"planet",satellites);
        this.satellites  = satellites!=null ? satellites : new HashSet<>();
    }
}
