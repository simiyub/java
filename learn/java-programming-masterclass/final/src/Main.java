import data.ExtendedPassword;
import data.Password;
import data.SomeClass;

public class Main {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("One");
        SomeClass two = new SomeClass("Two");
        SomeClass three = new SomeClass("Three");

        //Not possible as instanceNumber is final
        //one.instanceNumber=4;
        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);

        Password extendedPassword = new ExtendedPassword(pw);
        //Making the storePassword final protects it from being overriden.
        extendedPassword.storePassword();
        extendedPassword.letMeIn(1);
        extendedPassword.letMeIn(523266);
        extendedPassword.letMeIn(9773);
        extendedPassword.letMeIn(0);
        extendedPassword.letMeIn(-1);
        extendedPassword.letMeIn(674312);

        SIBTest testStaticInitBlock = new SIBTest();
        testStaticInitBlock.someMethod();
        System.out.println("Owner is"+SIBTest.owner);
    }
}
