package dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeCodeCampCourseTest {

    @Test
    void testFibTabulation() {
        assertEquals(1556111435, FreeCodeCampCourse.fibTabulation(1000));
    }

    @Test
    void testTravelGrid(){
        assertEquals(1, FreeCodeCampCourse.gridTravel(1,1));
        assertEquals(3, FreeCodeCampCourse.gridTravel(2,3));
        assertEquals(3, FreeCodeCampCourse.gridTravel(3,2));
        assertEquals(6, FreeCodeCampCourse.gridTravel(3,3));
        assertEquals(48620, FreeCodeCampCourse.gridTravel(10,10));
    }

    @Test
    void testCanSum(){
        assertTrue(FreeCodeCampCourse.canSum(7, new int[]{2, 3}));
        assertTrue(FreeCodeCampCourse.canSum(7, new int[]{5, 3, 4, 7}));
        assertFalse(FreeCodeCampCourse.canSum(7, new int[]{2, 4}));
        assertTrue(FreeCodeCampCourse.canSum(8, new int[]{2, 3, 5}));
        assertFalse(FreeCodeCampCourse.canSum(300, new int[]{7, 14}));
    }
}