package data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final String bodyType;


    public HeavenlyBody(String name, double orbitalPeriod,String bodyType, Set<HeavenlyBody> satellites) {

        this.bodyType = getBodyType(bodyType);
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites  = satellites!=null ? satellites : new HashSet<>();
        }


    String getBodyType(String bodyType) {
        String type;
        switch(bodyType.toUpperCase()){
            case("PLANET"):
                type = "PLANET";
                break;
            case("MOON"):
                type="MOON";
                break;
            case ("ASTEROID"):
                type="ASTEROID";
                break;
            case("STAR"):
                type="STAR";
                break;
            default:
                type= null;
                break;

        }
        return type;
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set getSatellites() {
        return new HashSet<HeavenlyBody>(satellites);
    }

    @Override
    public String toString() {
        return "Name:"+this.name+" Type:"+this.bodyType+" Period:"+this.orbitalPeriod+" moons:"+this.satellites;
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

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }
}
