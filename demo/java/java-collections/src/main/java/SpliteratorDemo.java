import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterators;

public interface SpliteratorDemo extends IteratorDemo {
    int characteristics();
    long estimateSize();
    Comparator getComparator();
    long getExactSizeIfKnown();
    boolean hasCharacteristics();
    boolean tryAdvance();
    Spliterators trySplit();
}
