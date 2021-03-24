package classes_and_interfaces;

import collections.Person;
import collections.ReverseComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

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
        Collections.sort(madMen,new AgeComparator());
        System.out.println(madMen);

        //Anonymous
        Collections.sort(madMen, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });
        System.out.println(madMen);

        //Passing up comparator
        Collections.sort(madMen,new ReverseComparator(new AgeComparator()));
        System.out.println(madMen);

    }
}
