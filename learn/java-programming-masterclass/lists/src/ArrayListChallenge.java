import data.Mobile;

public class ArrayListChallenge {
    public static void main(String[] args) {
        example();

        Mobile mobile = new Mobile("2","Samsung","6",2015);

        mobile.run();
    }

    private static void example() {
        Mobile mobile = new Mobile("1","Iphone", "6",2020);
        mobile.call("123456");
        mobile.store("123456");
        mobile.store("Peter", "678907");
        mobile.findNumber("678907");
        mobile.findName("Peter");
        mobile.store("George", "678907");
        mobile.store("Peter", "1234567");
        mobile.remove("1234567", "Peter");
        mobile.text("Hi", "Peter");
    }
}
