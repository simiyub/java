package collections;

import java.util.Arrays;

public class TheArrayProblem {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        Person[] madMen = {donDraper,peggyOlson};
        System.out.println(madMen);
        System.out.println(Arrays.toString(madMen));
        //No toString, we have to user utility.

        Person bertCooper = new Person("Bert Cooper", 100);
        madMen  = add(bertCooper, madMen);
        System.out.println(Arrays.toString(madMen));

        //hard to extend


    }

    private static Person[] add(Person person, Person[] people) {
        final int length = people.length;
        people = Arrays.copyOf(people,people.length+1);
        people[length] = person;
        return people;
    }
}