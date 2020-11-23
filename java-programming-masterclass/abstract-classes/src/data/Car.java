package data;

import java.util.Comparator;

public class Car extends Item {
    private String make, model, yearOfManufacture;
    public Car(String name, String source, double cost, String sourceDate) {
        this.name=name;
        this.source=source;
        this.cost=cost;
        this.sourceDate=sourceDate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public int compareTo(Car car) {
        int compareMake = this.make.compareToIgnoreCase(car.make);
        int compareModel = this.model.compareToIgnoreCase(car.model);
        int compareSource = this.source.compareToIgnoreCase(car.source);
        int compareSourceDate = this.sourceDate.compareToIgnoreCase(car.sourceDate);

        return compareMake!=0 ? compareMake:
                compareModel!=0? compareModel:
                        compareSource!=0? compareSource:
                                compareSourceDate;

    }

}
