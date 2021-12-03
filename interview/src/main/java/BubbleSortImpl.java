public class BubbleSortImpl implements BubbleSort{
    @Override
    public int[] sort(int[] array) {
        boolean sorted = true;
        int end = array.length-2;
        while(sorted) {

            sorted = false;
            for (int i=0;i<=end;i++) {
                if(array[i]>array[i+1])
                {
                    int oldValue = array[i];
                    array[i] = array[i+1];
                    array[i+1] = oldValue;
                    sorted = true;
                }

            }
            end --;
        }
        return array;
    }
}
