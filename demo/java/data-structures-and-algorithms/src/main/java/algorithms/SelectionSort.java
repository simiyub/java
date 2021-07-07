package algorithms;

public class SelectionSort
implements Sort {
    @Override
    public Comparable[] sort(Comparable[] array) {
        int n = array.length;            //method to find length of array
        for (int i = 0; i < n-1; i++)
        {
            int index = i;
            Comparable min = array[i];          // taking the min element as ith element of array
            for (int j = i+1; j < n; j++)
            {
                if (array[j].compareTo(array[index]) == -1 )
                {
                    index = j;
                    min = array[j];
                }
            }
            Comparable t = array[index];         //Interchange the places of the elements
            array[index] = array[i];
            array[i] = t;
        }
        return array;
    }
}
