
/**
 * Want to allow only types of a given super type
 * */
public class WildCardDemo<T extends Number> {
    T typeT;

    WildCardDemo(T typeT){
        this.typeT = typeT;
            }
            public T printType(){
                return typeT;
            }

    public T genericFunction(T type){
        return type;
    }
}
