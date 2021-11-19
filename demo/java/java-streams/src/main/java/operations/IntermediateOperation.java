package operations;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface IntermediateOperation<T> {
    Stream filter(Stream<Map.Entry> stream, String expected);
    Stream map(Stream<Map.Entry> stream);
    IntStream mapToInt(Stream<T> stream);
    DoubleStream mapToDouble(Stream<T> stream);
    Stream<T> flatMap(Stream<T> stream);
    DoubleStream flatMapToDouble(Stream<T> stream);
    Stream<T> distinct(Stream<T> stream);
    Stream<T> sorted(Stream<T> stream);
    Stream<T> peek(Stream<T> stream);
    Stream<T> limit(Stream<T> stream);
    Stream<T> skip(Stream<T> stream);
}
