package data;

import java.util.HashSet;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final HashSet<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }
    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public HashSet<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }
}
