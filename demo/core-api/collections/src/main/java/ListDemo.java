import java.util.ArrayList;
import java.util.List;

public interface ListDemo extends CollectionDemo{
    List unmodifiableList();
    List addAll(int index);
    List replaceAll();
    List sort();
    List get();
    List set();
    List add(int index);
    List remove(int index);
    int indexOf();
    int lastIndexOf();
    List subList();
    List of();
    ArrayList copyOf();




}
