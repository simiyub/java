package data;

public class Person {
    String firstName="";
            String lastName="";
    int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = 0;
        if(age>=0 && age<=100){
            this.age=age;
        }
    }

    public boolean isTeen() {
        return (age>12 && age <20);
    }

    public String getFullName() {
        return ((firstName.isEmpty() && lastName.isEmpty())?
                  ""
                : lastName.isEmpty()?
                  firstName
                : firstName.isEmpty()?
                  lastName
                : firstName+" "+lastName);
    }
}
