package data;

import java.util.Set;

public class Star extends HeavenlyBody{
    public Star(String name, double orbitalPeriod,
                Set<HeavenlyBody> satellites) {
        super(name, orbitalPeriod, "star", satellites);
    }
}
