
/**
 * Want to allow only types of a given super type?
 * To declare a bounded type parameter, list the type parameter's name,
 * followed by the extends keyword, followed by its upper bound,
 * which in this example is Number.
 * */
public class BoundedType<T extends Number> {
    private final T typeT;

    BoundedType(T typeT){
        this.typeT = typeT;
            }
            public T printType(){
                return typeT;
            }

    public <T> T genericFunction(T type){
        return type;
    }
}
