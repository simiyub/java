public class BinarySearchImp implements BinarySearch{
    @Override
    public int indexOf(int[] array, int requiredNumber) {
        int elementCount = array.length-1;
        return indexOf(array,Math.round(elementCount/2), requiredNumber);
    }

    private int indexOf(int[] array, int mid, int requiredNumber) {

        mid = Math.round(mid/2);

        if (array[mid]>requiredNumber) return indexOf(array,mid, requiredNumber);
        else if (array[mid]<requiredNumber) return indexOf(array,mid,requiredNumber);
        else return mid;
    }
}
