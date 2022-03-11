import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SetDemoImpl implements SetDemo{
    Set<T> set;
    public SetDemoImpl(Set<T> set) {
        this.set = set;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<T> action) {

    }

    @Override
    public Object[] toArray(IntFunction<T> generator) {
        return new Object[0];
    }

    @Override
    public boolean add(T o) {
        set.add(o);
        return set.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<T> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<T> filter) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public boolean removeAll(Collection<T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<T> c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
