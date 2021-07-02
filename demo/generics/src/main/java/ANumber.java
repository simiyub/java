public class ANumber extends Number implements Divisible {
    Number number;
    public ANumber(Number number) {
         this.number = number;
    }
    public boolean prime(Number number){
        int numberAsInt = number.intValue();
        boolean isPrime = true;
        for(int i = 2; i<=numberAsInt/2; ++i){
            if(numberAsInt %i == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime) System.out.println(number+" is prime");
        return isPrime;
    }

    @Override
    public boolean divisible(Number num) {
        return num.intValue() > 0;
    }

    @Override
    public int intValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double doubleValue() {
        throw new UnsupportedOperationException();
    }
}
