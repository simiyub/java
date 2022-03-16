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
}