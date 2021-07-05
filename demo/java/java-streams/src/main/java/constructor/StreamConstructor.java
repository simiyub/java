package constructor;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Contract of methods that we need to demo ways to obtain streams.
 * */
public interface StreamConstructor <E, T> {
    Stream<E> streamOfCollection(Collection<E> collection);
    Stream<T> streamOfArray(T[] array);
    Stream<String> streamOfLines(BufferedReader reader);
    Stream<Path> streamOfFilePaths(Path path);
    IntStream streamOfRandomInts(int size);
    IntStream streamOfRandomInts(int size, int origin, int bound);
    Stream<Object> streamOfObjects(Object[] objects);

    /* Other methods not in the demo
    IntStream.range(int, int) or Stream.iterate(Object, UnaryOperator);
    BitSet.stream(), Pattern.splitAsStream(java.lang.CharSequence), and JarFile.stream().
    * */
}
