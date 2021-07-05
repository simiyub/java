package constructor;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests to demo different ways to obtain streams
 * */

class StreamConstructorTest {

    @Test
    void streamOfCollection() {
        StreamConstructor<String, Object> constructor = new StreamConstructorImpl<>();
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = constructor.streamOfCollection(list);
        assertArrayEquals(list.toArray(),stream.toArray());

    }

    @Test
    void streamOfArray() {
        StreamConstructor<Object, Integer> constructor = new StreamConstructorImpl<>();
        Integer[] randomInts = new Integer[10];
        Random random = new Random();
        for (int i=0;i<10;i++){
            randomInts[i] = random.nextInt();
        }
        Stream<Integer> stream = constructor.streamOfArray(randomInts);
        assertArrayEquals(randomInts,stream.toArray());

    }

    @Test
    void streamOfLines() {
        StreamConstructor<BufferedReader,Object> constructor = new StreamConstructorImpl<>();
        BufferedReader reader = null;
        try {
            String path = "src/main/resources/workingDir/temp.text";
            reader = new BufferedReader(new FileReader(path));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(1,constructor.streamOfLines(reader).count());

    }

    @Test
     void streamOfFilePaths() {
        StreamConstructor<Path, Object> constructor = new StreamConstructorImpl<>();
        Stream<Path> stream = constructor.streamOfFilePaths(Paths.get("src/main/resources/workingDir/pathsTestDir"));
        assertEquals(2,stream.count());
    }

    @Test
    void streamOfRandomInts() {
        StreamConstructor<Integer,Object> constructor = new StreamConstructorImpl<>();
        int size = 10;
        IntStream stream = constructor.streamOfRandomInts(size);
        assertEquals(size, stream.count());
    }

    @Test
    void streamOfRandomIntsWithMinMax() {
        StreamConstructor<Integer,Object> constructor = new StreamConstructorImpl<>();
        int size =5;
        int origin = 10000;
        int bound = 1000000;
        IntStream originTestStream = constructor.streamOfRandomInts(size, 10000, 1000000);
        int originResult=originTestStream.max().orElse(Integer.MAX_VALUE);
        System.out.println("origin:"+originResult);
        assertTrue( origin <= originResult);

        IntStream boundTestStream = constructor.streamOfRandomInts(size, 10000, 1000000);
        int boundResult = boundTestStream.min().orElse(Integer.MIN_VALUE);
        System.out.println("bound:"+boundResult);
        assertTrue( bound >= boundResult);
    }

    @Test
    void streamOfObjects() {
        StreamConstructor<Student[],Object> constructor = new StreamConstructorImpl<>();
        int studentCount = 5;
        Student[] students = new Student[studentCount];
        for(int i=0; i<studentCount; i++){
            students[i] = new Student(i);
        }
        Stream<Object> stream = constructor.streamOfObjects(students);
        assertEquals(studentCount, stream.count());
    }
}