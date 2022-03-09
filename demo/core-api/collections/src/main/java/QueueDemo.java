import java.util.Collection;

public interface QueueDemo extends CollectionDemo {
    boolean offer();
    Collection remove();
    Collection poll();
    Collection element();
    Collection peek();


}
