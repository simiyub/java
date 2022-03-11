import model.PeopleType;
import model.Person;
import model.PersonAttributes;
import model.Teacher;

/**
 * This is the main class we use to demo generics.
 *  * Generics enable us to implement algorithms that flexibly work on objects of different types.
 *  * Java convention uses single uppercase letters for the type parameter name.
 *  * This is different from the ordinary class or interface name so there’s no confusion
 *  * 1. Code Reuse: We can write a method/class/interface once and use it for any type we want.
 *  * 2. Type Safety: Generics make errors to appear at compile time than at run time
 *
 *  In our examples, we demo generics as follows:
 * 1 - Invoking and instantiating a generic class
 * 2 - Inferring the type from the context hence empty <> diamond.
 * 3 - Parameterised type
 * */

public class GenericsDemo {

    public static void main(String[] args) {

        instantiateGenericClass();
        instantiateGenericClassWithInferredType();
        instantiateParameterisedType();
    }



    /**
     * 1 - Invoking and instantiating a generic class
     * */
    private static void instantiateGenericClass() {
        Person<Teacher> person1 = new Person<Teacher>(new PersonAttributes<>("name", "firstName"));
    }


    /**
     * 2 - In this case, we infer the type from the context.
     * We also demonstrate how to initialise a class with multiple type parameter
     * and the use of different types
     * */
    private static void instantiateGenericClassWithInferredType() {
        Person<Teacher> person2 = new Person<>(new PersonAttributes<>("age", 6));
    }

    /**
     * 3. Here we use the parameterised type model.Person as a parameter
     * */
    private static void instantiateParameterisedType() {
        PeopleType<String, Person<Teacher>> peopleType = new PeopleType<>("teacher", new Person<>(new PersonAttributes<>("name", "teacherOne")));
    }
}
