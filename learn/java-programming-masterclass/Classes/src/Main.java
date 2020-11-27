import data.*;
import data.carpetcostcalculator.Calculator;
import data.carpetcostcalculator.Carpet;
import data.carpetcostcalculator.Floor;

import java.awt.datatransfer.FlavorListener;


public class Main {
    public static void main(String[] args) {
        example();
        sumCalculatorCodingExercise();
        personCodingExercise();
        bankAccountChallenge();
        vipCustomerChallenge();
        codingExerciseWall();
        codingExercisePoint();
        codingExerciseCarpetCostCalculator();
        codingExerciseComplexOperation();

    }

    private static void codingExerciseComplexOperation() {

        ComplexNumber complex23_75 = new ComplexNumber(2.3,4.5);
        printComplexNumber(complex23_75);
        complex23_75.add(7.7,5.5);
        printComplexNumber(complex23_75);
        ComplexNumber complex_44_66=new ComplexNumber(4.4,6.6);
        complex23_75.add(complex_44_66);
        printComplexNumber(complex23_75);

        complex23_75.subtract(complex_44_66);
        printComplexNumber(complex23_75);
        complex23_75.subtract(7.7,5.5);
        printComplexNumber(complex23_75);

        ComplexNumber complex1_1 = new ComplexNumber(1.0,1.0);
        printComplexNumber(complex1_1);
        complex1_1.add(1,1);
        printComplexNumber(complex1_1);
        ComplexNumber complex25_15=new ComplexNumber(2.5,-1.5);
        complex1_1.subtract(complex25_15);
        printComplexNumber(complex1_1);
        printComplexNumber(complex25_15);
        complex25_15.subtract(complex1_1);
        printComplexNumber(complex25_15);
    }

    private static void printComplexNumber(ComplexNumber number) {
        System.out.println("["+number.getReal()+","+number.getImaginary()+"]");
    }

    private static void codingExerciseCarpetCostCalculator() {
        Floor defaultFloor = new Floor();
        defaultFloor.setLength(10);
        defaultFloor.setWidth(10);
        printFloorArea(defaultFloor);

        Floor defaultWithNegativeLength = new Floor();
        defaultWithNegativeLength.setLength(-1);
        defaultWithNegativeLength.setWidth(100);
        printFloorArea(defaultWithNegativeLength);

        Floor defaultWithNegativeWidth = new Floor();
        defaultWithNegativeWidth.setLength(10);
        defaultWithNegativeWidth.setWidth(-12);
        printFloorArea(defaultWithNegativeWidth);

        Floor dimensionfloor = new Floor(4,5);
        printFloorArea(dimensionfloor);

        Floor dimensionFloorWithNegativeWidth=new Floor(-1,10);
        printFloorArea(dimensionFloorWithNegativeWidth);

        Floor dimensionFloorWithNegativeHeight=new Floor(10,-10);
        printFloorArea(dimensionFloorWithNegativeHeight);

        Carpet carpet = new Carpet();
        Carpet carpetWithCost = new Carpet(5.0);
        System.out.println("cost of default carpet is="+carpet.getCost());
        System.out.println("cost of costed carpet is="+carpetWithCost.getCost());

        Calculator calculator = new Calculator(new Floor(4,5), new Carpet(10));
        printCarpetingCost(calculator);
    }

    private static void printCarpetingCost(Calculator calculator) {
        System.out.println("total cost of carpeting a floor of area="
                +calculator.getFloor().getArea()
                +"\n at "+calculator.getCarpet().getCost()+" per square meter is:\n"
                +calculator.getTotalCost());
    }

    private static void printFloorArea(Floor floor) {
        System.out.println("area of floor ["+floor.getWidth()+"X"+floor.getLength()+"]="+floor.getArea());
    }

    private static void codingExercisePoint() {
        Point defaultPoint=new Point();
        defaultPoint.setX(3);
        defaultPoint.setY(4);
        System.out.println("distance from [0,0] to [3,4] is "+defaultPoint.distance());

        Point point22=new Point(2,2);
        System.out.println("distance from [2,2] to [4,5] is "+point22.distance(4,5));

        Point point1010=new Point(10,10);
        System.out.println("distance from [2,2] to [10,10] is "+point22.distance(point1010));
    }


    private static void codingExerciseWall() {
        Wall defaultWall=new Wall();
        printWallArea(defaultWall);
        Wall withWidthAndHeight = new Wall(2.5, 4);
        printWallArea(withWidthAndHeight);
    }

    private static void printWallArea(Wall wall) {
        System.out.println("area of wall["+wall.getWidth()+"X"+wall.getHeight()+"]="+wall.getArea());
    }

    private static void vipCustomerChallenge() {
        VIPCustomer vipDefault=new VIPCustomer();
        printCustomerDetails(vipDefault);
        VIPCustomer vipWithTwoValues=new VIPCustomer("two values", "two.values@bank.com");
        printCustomerDetails(vipWithTwoValues);
        VIPCustomer vipWithValues=new VIPCustomer("with values", 20.00,"with.values@bank.com");
        printCustomerDetails(vipWithValues);
    }

    private static void printCustomerDetails(VIPCustomer customer) {
        System.out.println("customer name:"+customer.getName()+"\nemail:"+customer.getEmail()+"\ncredit limit="+customer.getCreditLimit());
    }

    private static void bankAccountChallenge() {
        BankAccount account = new BankAccount("12345","Customer Name", "customer@bank.com", "6789");
        account.printDetails();
        account.getBalance();
        account.deposit(12.00);
        account.withdraw(5.00);
        account.withdraw(12.00);
    }

    private static void personCodingExercise() {
        Person teen=new Person();
        int teenAge=14;
        teen.setAge(teenAge);
        System.out.println(teenAge+" is teenage="+teen.isTeen());

        Person nonTeen=new Person();
        int nonTeenage=24;
        nonTeen.setAge(nonTeenage);
        System.out.println(nonTeenage+" is teenage="+nonTeen.isTeen());

        Person nameLessPerson=new Person();
        System.out.println("nameless person Full name="+nameLessPerson.getFullName());

        Person firstNamePerson=new Person();
        firstNamePerson.setFirstName("First");
        System.out.println("firstNamePerson Full name="+firstNamePerson.getFullName());

        Person lastNamePerson=new Person();
        lastNamePerson.setLastName("Last");
        System.out.println("lastNamePerson Full name="+lastNamePerson.getFullName());

        Person fullNamePerson=new Person();
        fullNamePerson.setFirstName("First");
        fullNamePerson.setLastName("Last");
        System.out.println("fullNamePerson Full name="+fullNamePerson.getFullName());


    }

    private static void sumCalculatorCodingExercise() {
        SimpleCalculator calculator=new SimpleCalculator();
        calculator.setFirstNumber(1.2);
        calculator.setSecondNumber(1.3);
        System.out.println(calculator.getAdditionResult());
        System.out.println(calculator.getSubtractionResult());
        System.out.println(calculator.getMultiplicationResult());
        System.out.println(calculator.getDivisionResult());
        calculator.setSecondNumber(0);
        System.out.println(calculator.getDivisionResult());
    }

    private static void example() {
        Car porsche = new Car();
        Car holden = new Car();
        porsche.setModel("Carrera");
        holden.getModel();
        System.out.println(porsche.getModel());
        System.out.println(holden.getModel());
    }
}
