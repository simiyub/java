import data.Car;
import data.Movie;

public class Main {
    public static void main(String[] args) {

        for(int i=1; i<11; i++){
            Movie movie=Movie.randomMovie();
            System.out.println("data.Movie #"+ i +"\n"+ "Plot:"+movie.plot()+"\n");
        }

        Car car = new Car(4,"Mercedes",4,true);
        Car randomCar=Car.getCar(500);
        System.out.println("Your Car is [drum roll....]..a "+randomCar.getMake());
        randomCar.startEngine();
        randomCar.accelerate();
        randomCar.brake();

    }

}
