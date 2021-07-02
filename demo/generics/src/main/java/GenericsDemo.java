
/**
 * 1. Code Reuse: We can write a method/class/interface once and use it for any type we want.
 *
 * 2. Type Safety: Generics make errors to appear compile time than at run time
 * */
public class GenericsDemo <T> {
    T typeT;

    GenericsDemo(T typeT){
        this.typeT = typeT;
            }
            public T printType(){
                return typeT;
            }

    public static class GenericsDemoTwoTypes <T, U> {
        T typeT;
        U typeU;
        GenericsDemoTwoTypes(T typeT, U typeU){
            this.typeT = typeT;
            this.typeU = typeU;

        }
        public String printType(){
            return typeT.toString() + typeU.toString();
        }
    }

    public T genericFunction(T type){
        return type;
    }
}
