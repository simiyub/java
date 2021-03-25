package wildcards;

import collections.Person;

import java.util.*;

import static java.util.stream.Collectors.partitioningBy;

public class App {
    public static void main(String[] args) {
        Set<Integer> ids = hashSet(1,2,3,4,5,6,7,8,9,10);
        System.out.println(ids);
        List<Employee> employees = List.of(
                new Employee("Peter", 34,1),
                new Employee("George", 24,2),
                new Employee("Park", 15,3));

        List<Partner> partners = List.of(
                new Partner("James", 56, 4,"President"),
                new Partner("Fiona", 49, 5, "Vice President"),
                new Partner("Lana", 55,6, "Secretary")
        );
        printAll(partners);
        List<List<? super Partner>> allEmployees = List.of(employees,partners);
        printAllEmployees(allEmployees);

        List <Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Employee("Tuko", 34,1));

        Map<Boolean, List<Person>> oldAndYoungPeople = employees.stream().collect(partitioningBy(person -> person.getAge() > 80));
        System.out.println(oldAndYoungPeople);

    }

    private static void printAllEmployees(List<List<? super Partner>> allEmployees) {
        for(List list:allEmployees){
            list.forEach(employee -> System.out.println(employee));
        }
    }

    //? extends className example
    private static void printAll(final List<? extends Person> list) {
        for (Person person:list){
            System.out.println(person);
        }
    }


    private static <T> Set<T> hashSet( T ...ints) {
        Set<T> set = new HashSet();
        Collections.addAll(set,ints);
        return set;
    }


}
