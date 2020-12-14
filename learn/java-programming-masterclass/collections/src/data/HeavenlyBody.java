package data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HeavenlyBody <T extends HeavenlyBody>  {
    private final String name;
    private final double orbitalPeriod;
    private final Set<T> satellites;
    private final String bodyType;
    private final String id;


    public HeavenlyBody(String name, double orbitalPeriod,String bodyType, Set<T> satellites) {

        this.bodyType = getBodyType(bodyType);
        this.name = name;
        this.id = name+bodyType;
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

    public boolean addSatellite(T satellite){
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

    public String getBodyType() {
        return bodyType;
    }

    public String getId() {
        return id;
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
        String name = ((HeavenlyBody) obj).getName();
        String type = ((HeavenlyBody) obj).getBodyType();
        return this.name.equalsIgnoreCase(name) && this.bodyType.equalsIgnoreCase(type);

    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+this.bodyType.hashCode() + 57;
    }
}
