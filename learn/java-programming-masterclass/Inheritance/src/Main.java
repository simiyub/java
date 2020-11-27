import data.*;

public class Main {
    public static void main(String[] args) {
        example();
        challenge();
    }

    private static void challenge() {
        RangeRover range = new RangeRover("Left","Vogue",2020,5,200,false,300,200,150);
        range.accelerate(30);
        codingExercise35();
        codingExercise36();
    }

    private static void codingExercise36() {
        Rectangle rectangle = new Rectangle(10,10);
        rectangle.getArea();
        Cuboid cuboid = new Cuboid(5,5,10);
        cuboid.getVolume();
    }

    private static void codingExercise35() {
        Circle circle=new Circle(10);
        circle.getArea();
        Cylinder cylinder=new Cylinder(10,10);
        cylinder.getVolume();
    }

    private static void example() {
        Animal animal = new Animal("dog",1,1,10,50);
        System.out.println(animal.getName());
        Dog dog = new Dog("Yorkie",10,50, 2, 4, 1, 12,"long silky" );
        dog.eat("meat");
        dog.walk();
        Fish fish = new Fish("name",4,2,3, 4);
    }
}
