package operations;

import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationImpl<T> implements IntermediateOperation<T> {

    @Override
    public Stream filter(Stream<Map.Entry> stream, String expected) {
        return stream.filter(e -> e.getValue() == expected);
    }



    @Override
    public Stream map(Stream<Map.Entry> stream) {
        return stream.map(e  -> e.getKey()+"-"+e.getValue());
    }

    @Override
    public IntStream mapToInt(Stream<T> stream) {
        return null;
    }

    @Override
    public DoubleStream mapToDouble(Stream<T> stream) {
        return null;
    }

    @Override
    public DoubleStream flatMapToDouble(Stream<T> stream) {
        return null;
    }

    @Override
    public Stream flatMap(Stream stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream distinct(Stream stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream sorted(Stream stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream peek(Stream stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream limit(Stream stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream skip(Stream stream) {
        throw new UnsupportedOperationException();
    }
}
