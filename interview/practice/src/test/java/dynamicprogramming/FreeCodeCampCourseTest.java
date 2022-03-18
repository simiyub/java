package dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FreeCodeCampCourseTest {

    @Test
    void testFibTabulation() {
        assertEquals(1556111435, FreeCodeCampCourse.fibTabulation(1000));
    }

    @Test
    void testTravelGrid() {
        assertEquals(1, FreeCodeCampCourse.gridTravel(1, 1));
        assertEquals(3, FreeCodeCampCourse.gridTravel(2, 3));
        assertEquals(3, FreeCodeCampCourse.gridTravel(3, 2));
        assertEquals(6, FreeCodeCampCourse.gridTravel(3, 3));
        assertEquals(48620, FreeCodeCampCourse.gridTravel(10, 10));
    }

    @Test
    void testCanSum() {
        assertTrue(FreeCodeCampCourse.canSum(7, new int[]{2, 3}));
        assertTrue(FreeCodeCampCourse.canSum(7, new int[]{5, 3, 4, 7}));
        assertFalse(FreeCodeCampCourse.canSum(7, new int[]{2, 4}));
        assertTrue(FreeCodeCampCourse.canSum(8, new int[]{2, 3, 5}));
        assertFalse(FreeCodeCampCourse.canSum(300, new int[]{7, 14}));
    }

    @Test
    void testHowSum() {
        assertEquals(7, Arrays.stream(FreeCodeCampCourse.howSum(7, new int[]{2, 3})).sum());
        assertEquals(7, Arrays.stream(FreeCodeCampCourse.howSum(7, new int[]{5, 3, 4})).sum());
        assertEquals(0, Arrays.stream(FreeCodeCampCourse.howSum(7, new int[]{2, 4})).sum());
        assertEquals(8, Arrays.stream(FreeCodeCampCourse.howSum(8, new int[]{2, 3, 5})).sum());
        assertEquals(0, Arrays.stream(FreeCodeCampCourse.howSum(300, new int[]{7, 14})).sum());
    }

    @Test
    void testBestSum() {
        assertEquals(3, Arrays.stream(FreeCodeCampCourse.bestSum(7, new int[]{2, 3})).count());
        assertEquals(2, Arrays.stream(FreeCodeCampCourse.bestSum(7, new int[]{5, 3, 4})).count());
        assertNull(FreeCodeCampCourse.bestSum(7, new int[]{2, 4}));
        assertEquals(2, Arrays.stream(FreeCodeCampCourse.bestSum(8, new int[]{2, 3, 5})).count());
        assertNull(FreeCodeCampCourse.bestSum(300, new int[]{7, 14}));
    }

    @Test
    void testCanConstruct() {

    assertTrue(FreeCodeCampCourse.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        assertFalse(FreeCodeCampCourse.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        assertFalse(FreeCodeCampCourse.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeee"}));
    }

    @Test
    void testCountConstruct() {
        assertEquals(2, FreeCodeCampCourse.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        assertEquals(1, FreeCodeCampCourse.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        assertEquals(0, FreeCodeCampCourse.countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        assertEquals(0, FreeCodeCampCourse.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeee"}));
    }
    
    @Test
            void tesAllConstructs() {

        assertArrayEquals(new String[][]{new String[]{"purp", "le"}, new String[]{"p", "ur", "p", "le"}}, FreeCodeCampCourse.allConstructs("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        assertArrayEquals(new String[][]{new String[]{"ab", "cd", "ef"}, new String[]{"ab", "c", "def"}, new String[]{"abc", "def"}, new String[]{"abcd", "ef"}}, FreeCodeCampCourse.allConstructs(
                "abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
    }
}