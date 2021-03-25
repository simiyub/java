package methods;

import classes_and_interfaces.AgeComparator;
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
        final Person youngestCastMember = minimum(madMen, new AgeComparator());
        System.out.println(youngestCastMember);

        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(9);
        list.add(12);
        System.out.println(list);
        System.out.println(minimum(list,Integer::compare));


    }

    private static <T> T minimum(List<T> list, Comparator<T> comparator) {
        if (list.isEmpty()) throw new IllegalArgumentException("List is empty");

        T least = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            final T element = list.get(i);
            if (comparator.compare(element, least) < 0) least = element;
        }
        return least;
    }
}
