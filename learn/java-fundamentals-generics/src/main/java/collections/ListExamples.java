package collections;

import collections.Person;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        System.out.println(madMen);
        Person bertCooper = new Person("Bert Cooper", 100);
        madMen.add(bertCooper);
        System.out.println(madMen);

    }
}
