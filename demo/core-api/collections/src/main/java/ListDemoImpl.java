import java.util.List;

public class ListDemoImpl {
    List list;
    public ListDemoImpl(List<String> list) {
        this.list = list;
    }


    public boolean add(String value) {
        list.add(value);
        return list.contains(value);
    }
}
