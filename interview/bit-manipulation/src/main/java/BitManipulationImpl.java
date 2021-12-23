public class BitManipulationImpl implements BitManipulation {

    /**
     *This function does a right shift of the number n
     * by the value of the position required, placing the
     * kth bit at position 0. Applying the & operator then gives
     * as the bit value at the kth position.
     * */
    @Override
    public char valueOfKthBit(int n, int position) {
        int result = n & (1<<position);
        System.out.println(result);
        return result == 0 ? '0' : '1';
    }
}
