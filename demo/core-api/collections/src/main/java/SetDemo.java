import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface SetDemo{


     int size();


     boolean isEmpty();


     boolean contains(Object o);


     Iterator<T> iterator();


     void forEach(Consumer<T> action);



     Object[] toArray(IntFunction<T> generator);


     boolean add(T o);


     boolean remove(Object o);


     boolean addAll(Collection<T> c);


     boolean removeIf(Predicate<T> filter);


     void clear();


     Spliterator<T> spliterator();


     Stream<T> stream();


     Stream<T> parallelStream();


     boolean removeAll(Collection<T> c);


     boolean retainAll(Collection<T> c);


     boolean containsAll(Collection<T> c);


     Object[] toArray(Object[] a);

}
