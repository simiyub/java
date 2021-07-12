package algorithms;

public class QuickSort{


    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length-1);
    }

    private int[] quickSort(int[] array, int left, int right) {
        if(left >=right) return array;
        int pivot = array[(left+right)/2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index-1);
        quickSort(array,index, right);
        return array;
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while(left < right){
            while (array[left] < pivot) left ++;
            while (array[right] > pivot) right --;
            if(left<=right){
                int leftValue = array[left];
                array[left] = array[right];
                array[right] = leftValue;
                left ++;
                right --;
            }
        }
        return left;
    }
}
