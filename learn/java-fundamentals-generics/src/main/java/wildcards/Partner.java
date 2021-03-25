package wildcards;

public class Partner <T> extends Employee {
    private final String level;

    public Partner(String name, int age, int id, String level) {
                super(name, age,id);
                this.level = level;
    }

    @Override
    public String toString() {
        return super.toString()+" and is a partner, level: "+level;
    }
}
