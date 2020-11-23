public class StaticTest {
    //Making this static then it's shared across instances
    //Static variables and methods are to class not instance
    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName()+" is "+getNumInstances();
    }
}
