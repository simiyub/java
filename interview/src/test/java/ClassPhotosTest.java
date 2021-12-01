import classphoto.ClassPhotoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassPhotosTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void feasible() {
        int[] jumper=new int[]{5,8, 1, 3, 4};
        int[] noJumper = new int[]{6, 9, 2, 4, 5};
        assertTrue(new ClassPhotoImpl().feasible(jumper, noJumper));
    }
}