package arrays;

public interface ArraysDemo {
    int[] init(int i, int i1, int i2, int i3);
    char[] initShort(char a, char b, char c, char d, char e);
    String[][] multiDimensional(String[] stringArray1, String[] stringArray2);
    int[] arrayCopy(int[] array1, int[] array2, boolean manual);
    String[] fill(String[] array, String filler);
    int binarySearch(String[] array, String searchElement);
    boolean equal(String[] array1, String[] array2);
    String[] sort(String[] array);
    String[] remove(String[] array, String removeElement);
}
