import java.util.Collection;

/**
 * Methods declared in collections interface.
 * These form part of the contract that the demo implementation will fulfill
 * */
public interface CollectionDemo {
    //clear, equals, hashcode, spliterator, stream, parallelStream, toArray, iterator, size
    Collection add();
    Collection addAll();
    Collection remove();
    Collection removeAll();
    Collection removeIf();
    Collection retailAll();
    Collection contains();
    Collection isEmpty();


    Collection forEach();

}
