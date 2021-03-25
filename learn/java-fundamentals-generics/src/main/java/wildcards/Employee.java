package wildcards;

import collections.Person;

public class Employee <T> extends Person {
    private int employeeID;
    public Employee(String name, int age, int id) {
        super(name, age);
        setEmployeeID(id);
    }

    int getEmployeeID() {
        return employeeID;
    }

    private void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return super.toString()+" is employee "+employeeID;
    }
}
