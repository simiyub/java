import data.Seat;
import data.Theatre;

import java.util.*;

/**
 *
 *https://docs.oracle.com/javase/tutorial/collections/intro/index.html
 * Declaring collection as an interface such as collection, List, Set etc,
 * we can change the implementation without breaking our code
 *
 * HashMap - No ordering
 * */
public class Main {


    public static void main(String[] args) {
        //listDemo();
        mapDemo();




    }

    private static void mapDemo() {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "Java is a computer programming language. It enables programmers " +
                "to write computer instructions using English-based commands instead of having " +
                "to write in numeric codes. It’s known as a high-level language because it can be " +
                "read and written easily by humans.");
        languages.put("Python", "Python is an interpreted, object-oriented, high-level programming " +
                "language with dynamic semantics. Its high-level built in data structures, combined " +
                "with dynamic typing and dynamic binding, make it very attractive for " +
                "Rapid Application Development, as well as for use as a scripting or glue language " +
                "to connect existing components together.");
        languages.put("C++", "C++ is a powerful general-purpose programming language. " +
                "It can be used to develop operating systems, browsers, games, and so on. C++ " +
                "supports different ways of programming like procedural, object-oriented, " +
                "functional, and so on. This makes C++ powerful as well as flexible.");

        languages.put("JavaScript", null);

        Map<String, String> languageResource = new HashMap<>();
        languageResource.put("Python", "https://www.python.org/doc/essays/blurb/");
        languageResource.put("Java", "https://www.thoughtco.com/what-is-java-2034117" );
        languageResource.put("C++", "https://www.programiz.com/cpp-programming");

        System.out.println(languages.get("Java"));
        System.out.println(languages.get("Python"));
        System.out.println(languages.get("C++"));
        System.out.println(languages.get("Lisp"));

        demoUsefulFunction(languages);
    }

    private static void demoUsefulFunction(Map languages) {
        //find duplicates
        //put if absent is more for concurrency
        System.out.println(languages.containsKey("React"));
        if (!languages.containsKey("React")){
            languages.put("React", null);
        }
        System.out.println(languages.containsKey("React"));

        //print map contents
        System.out.println(languages.keySet());
        System.out.println(languages.entrySet());
    }

    private static void listDemo() {
        Theatre theatre = new Theatre("Theatre 1", 25,  10);
        theatre.showSeats();
        theatre.reserveSeat("A10");
        theatre.reserveSeat("A10");

        CollectionsMethods.demo();

        List<Seat> priceSeats = new ArrayList<>();
        priceSeats.add(new Seat("B20",20));
        priceSeats.add(new Seat("B00", 10));
        priceSeats.add(new Seat("B15", 15));

        Collections.sort(priceSeats,Seat.PRICE_ORDER);
        System.out.println(priceSeats);
    }
}
