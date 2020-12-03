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

    @Override
    public String toString() {
        return "Name:"+this.name+" Period:"+this.orbitalPeriod+" moons:"+this.satellites;
    }

    //without the override, the method will never be used, instead you'd probably overload it and method never used
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        System.out.println("obj.getClass() is "+obj.getClass());
        System.out.println("this.getClass() is "+obj.getClass());
        if((obj==null)||(obj.getClass()!=this.getClass())){
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);

    }
}
