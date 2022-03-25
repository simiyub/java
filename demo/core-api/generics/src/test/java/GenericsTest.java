import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsTest{
    private Generics<String> demo;
    private String testDemoTypeT;


    @BeforeEach
    void setUp() {
        testDemoTypeT = "TestDemoTypeT";
        demo = new Generics<>(testDemoTypeT);
    }

    @Test
    void printOneType(){
        System.out.println(demo.printType());
        assertEquals(testDemoTypeT,demo.printType());
    }

    @Test
    void printTwoTypes(){
        String type1="one";
        int type2 = 1;
        Generics.GenericsDemoTwoTypes<String,Integer> demoTwoTypes = new Generics.GenericsDemoTwoTypes<>(type1, type2);
        System.out.println(demoTwoTypes.printType());
        assertEquals(demoTwoTypes.printType(),type1+type2);
    }

    @Test
    void genericFunction(){
        String genericFunc = "genericFunc";
        String result = demo.genericFunction(genericFunc);
        System.out.println(result);
        assertEquals(genericFunc, result);
    }
}