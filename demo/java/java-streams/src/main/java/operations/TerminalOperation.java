package operations;

import java.util.Optional;
import java.util.stream.Stream;

public interface TerminalOperation <T>{
    Stream<T> forEach(Stream<T> stream);
    Stream<T> forEachOrdered(Stream<T> stream);
    Stream<T> reduce(Stream<T> stream);
    Stream<T> collect(Stream<T> stream);
    Optional<T> min(Stream<T> stream);
    Optional<T> max(Stream<T> stream);
    Optional<T> findFirst(Stream<T> stream);
    Optional<T> findAny(Stream<T> stream);
    boolean allMatch(Stream<T> stream);
    long count(Stream<T> stream);
}
