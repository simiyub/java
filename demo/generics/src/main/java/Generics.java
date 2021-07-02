
/**
 * Generics enable us to implement algorithms that flexibly work on objects of different types.
 * Java convention uses single uppercase letters for the type parameter name.
 * This is different from the ordinary class or interface name so there’s no confusion
 * 1. Code Reuse: We can write a method/class/interface once and use it for any type we want.
 *
 * 2. Type Safety: Generics make errors to appear compile time than at run time
 * */
public class Generics<T> {
    T typeT;

    Generics(T typeT){
        this.typeT = typeT;
            }
            public T printType(){
                return typeT;
            }

    public static class GenericsDemoTwoTypes <T, S> {
        T typeT;
        S typeS;
        GenericsDemoTwoTypes(T typeT, S typeS){
            this.typeT = typeT;
            this.typeS = typeS;

        }
        public String printType(){
            return typeT.toString() + typeS.toString();
        }
    }

    public T genericFunction(T type){
        return type;
    }
}
