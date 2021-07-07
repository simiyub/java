package algorithms;

public class HeapSortImpl implements HeapSort{
    @Override
    public Comparable[] maxHeapify(Comparable[] arr, Integer node, Integer heapLength) {
        Integer left = node*2;
        Integer right = node*2+1;
        Integer largest = node;

        if(left.compareTo(heapLength) <=0 && arr[left-1].compareTo(arr[node-1]) >= 0){
            largest = left;
        }
        if(right.compareTo(heapLength) <= 0 && arr[right-1].compareTo(arr[largest-1]) >= 0){
            largest = right;
        }
        if(largest != node){
            Comparable temp = arr[node-1];
            arr[node-1] = arr[largest-1];
            arr[largest-1] = temp;
            maxHeapify(arr, largest, heapLength);
        }
        return arr;
    }

    @Override
    public Comparable[] sort(Comparable[] array) {
        int heapLength = array.length;
        for(int i = array.length/2; i>0; i--){
            array=maxHeapify(array,i, heapLength);
        }

        for(int i=array.length-1;i>=0;i--){
            Comparable max = array[0];
            array[0] = array[i];
            array[i] = max;
            heapLength--;
            array = maxHeapify(array,1,heapLength);
        }
        return array;
    }
}
