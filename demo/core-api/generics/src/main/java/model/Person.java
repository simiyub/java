package model;

public class Person<T> {
    private Person<T> person;
    private PersonAttributes<String, Object> nameAttribute = null;

    public Person(PersonAttributes<String,Object> nameAttribute) {
        person = new Person<>();
        person.nameAttribute = nameAttribute;

    }

    public Person() {
    }

    public Person<T> getPerson() {
        return person;
    }

    public PersonAttributes<String, Object> getNameAttribute() {
        return nameAttribute;
    }
}