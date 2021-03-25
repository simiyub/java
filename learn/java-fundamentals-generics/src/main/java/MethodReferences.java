import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MethodReferences {

    public static void main(String[] args) {

        List<String> array = Arrays.asList("george","peter","paul");

        //lambda expression
        array.forEach(word -> System.out.println(StringUtils.capitalize(word)));

        //Method reference to static method
        array.forEach(StringUtils::upperCase);


    }
}
