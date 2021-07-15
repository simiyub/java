
/**
 *  A type variable with multiple bounds is a subtype of all the types listed in the bound.
 *  If one of the bounds is a class, it must be specified first.
 *  By the way, only the first Type can be a class, the rest need to be interfaces
 * */
public class MultipleBoundType <T extends ANumber & Divisible > {
        private final T type;

        public MultipleBoundType(T type) {
            this.type = type;
        }

        Object type(){
            return type;
        }

    }
