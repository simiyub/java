package constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Implementation demo of different ways to obtain streams
 * */

public class StreamConstructorImpl <E, T> implements StreamConstructor<E,T> {
    @Override
    public Stream<E> streamOfCollection(Collection<E> collection) {
        return collection.stream();
    }

    @Override
    public Stream<T> streamOfArray(T[] array) {
        return Arrays.stream(array);
    }

    @Override
    public Stream<String> streamOfLines(BufferedReader reader) {
        return reader.lines();
    }

    @Override
    public Stream<Path> streamOfFilePaths(Path path) {
        Stream<Path> stream = null;
        try {
            stream = Files.list(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return stream;
    }


    @Override
    public IntStream streamOfRandomInts(int size) {
        Random random =  new Random();
        return random.ints(size);
    }

    @Override
    public IntStream streamOfRandomInts(int size, int origin, int bound) {
        Random random =  new Random();
        return random.ints(size,origin,bound);
    }

    @Override
    public Stream<Object> streamOfObjects(Object[] objects) {

        return Stream.of(objects);
    }

    @Override
    public Stream<Student> streamIterate(Student student, int count) {
        return Stream.iterate(student, n -> new Student(student.id+1)).limit(count);
    }

    @Override
    public IntStream streamOfPrimitiveInt(int start, int end) {
        return IntStream.range(start,end);
    }

    @Override
    public IntStream streamOfPrimitiveIntIncludingEnd(int start, int end) {
        return IntStream.rangeClosed(start,end);
    }

    @Override
    public DoubleStream streamOfPrimitiveDoubles(int count) {
        return new Random().doubles(count);
    }

    @Override
    public Stream<String> streamOfStrings(String string, String separator) {
        return Pattern.compile(separator).splitAsStream(string);
    }

    @Override
    public IntStream streamOfStrings(String strings) {
        return strings.chars();
    }
}
