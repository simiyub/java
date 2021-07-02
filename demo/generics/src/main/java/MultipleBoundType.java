public class MultipleBoundType <T extends ANumber & Divisible > {
        private final T type;

        public MultipleBoundType(T type) {
            this.type = type;
        }

        Object type(){
            return type;
        }

    }
