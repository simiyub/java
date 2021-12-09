import movetotheend.MoveToTheEndImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveToTheEndTest {

    @Test
    void moveToTheEndTest(){
        int[] expected = new int[]{4,1,3,2,2,2,2,2};
        int[] array = new int[]{2,1,2,2,2,3,4,2};
        int toMove =2;
        assertArrayEquals(expected, new MoveToTheEndImpl().move(array,toMove));
    }

    @Test
    void moveToTheEndTest2(){
        int[] expected = new int[]{3,3,3,3,3};
        int[] array = new int[]{3,3,3,3,3};
        int toMove =3;
        assertArrayEquals(expected, new MoveToTheEndImpl().move(array,toMove));
    }

}