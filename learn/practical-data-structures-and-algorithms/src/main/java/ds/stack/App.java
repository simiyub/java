package ds.stack;

import com.sun.jdi.event.StepEvent;

import java.util.Arrays;

public class App {
    int[] heapArray;
    int heapCapacity;
    int heapSize;

    public static void main(String[] args) {
        int[] array = {3,7,3,7,4,8,9,-1,4,2,56,-14,8};
        //mergeSort(array, 0, array.length-1);
        //quickSort(array,0, array.length-1);
       // System.out.println(Arrays.toString(array));
        App app = new App();
       // app.binarySearchTree(array);
       // app.minHeapDataStructure();
       // app.maxHeapDataStructure();
        app.hashTable();
    }

    public class HashTableDemo {

        private int capacity;
        private int size;
        private String[] hashArray;

        HashTableDemo(int slots) {
            int cap = slots;
            size = 0;
            cap = prime( slots);
            this.capacity = cap;
            hashArray = new String[cap];
        }

        private int prime( int val) {
            int prime = val;
            boolean isPrime = true;
            for (int i = 2; i<val; i++) {
                if (val % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(!isPrime){
                prime = prime(val+1);
                System.out.println(val + " is not prime");
            }
            System.out.println(prime +" is prime");
            return prime;
        }

        private void ensureCapacity() {
            if (capacity-size <=2){
                hashArray = Arrays.copyOf(hashArray, capacity*2);
                capacity *= 2;
            }
        }

        public void insert(String word) {
            System.out.println("insert..");
            ensureCapacity();
            int preferredIndexHash = preferredIndexHash(word);
            int stepHash = stepSizeHash(word);
            while (hashArray[preferredIndexHash]!=null){
                preferredIndexHash = preferredIndexHash +stepHash;
                preferredIndexHash = preferredIndexHash % size;
            }
            hashArray[preferredIndexHash] = word;
            System.out.println(word+   " inserted.");
            size ++;
        }

        private int stepSizeHash(String word) {
            int hashVal = hash(word);
            //step size greater than zero
            //use a prime number less than the array size
            return 3 - hashVal%3;
        }

        private int preferredIndexHash(String word) {
            int hashVal = hash(word);
            return hashVal;
        }

        private int hash(String word) {
            int hashVal = word.hashCode();
            int div = size != 0 ? size : 1;
            hashVal = hashVal%div;
            if (hashVal<0){
                hashVal+=div;
            }
            return hashVal;
        }

        public String find(String word) {
            System.out.println("find..");
            int hash = preferredIndexHash(word);
            int step = stepSizeHash(word);
            String found="";
            while (hashArray[hash] !=null){
                 if(hashArray[hash].equals(word)){
                     found = hashArray[hash];
                     break;
                 }
                 else{
                     hash = hash +step;
                     hash = hash % size;
                 }
             }
             found = hashArray[hash];
             System.out.println( word + (found.equals(word)? " found": " not found"));
             return found;
        }
    }

    private void hashTable() {
        HashTableDemo hashTable = new HashTableDemo(3);
        System.out.println("capacity = "+hashTable.capacity);
        String word="fearless";
        hashTable.insert(word);
        hashTable.find(word);
        hashTable.find("none");

    }

    class HeapNode {
        int value;
        HeapNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    class Heap{
        private HeapNode[] heap;
        private int capacity;
        private int size;
        Heap(int cap){
            capacity = cap;
            size = 0;
            heap = new HeapNode[capacity];
        }

        public int getSize() {
            return size;
        }
        public boolean isEmpty(){
            return size == 0;
        }

        public int parentIndex(int index){return (index-1)/2;}

        public int leftChildIndex(int index){return (2*index)+1;}

        public  int rightChildIndex(int index){return (2*index)+2;}


        public boolean insert(int val){
            ensureCapacity();

            int index=0;
            if(size>0){
                index = size;
            }
            ++size;
            heap[index] = new HeapNode(val);
            trickleUp(index);

            return true;
        }
        public int delete(){
            int value = heap[0].value;
            heap[0] = heap[size];
            trickleDown(0);
            size--;
            return value;
        }

        private void swap(int oneIndex, int twoIndex){
            HeapNode nodeOne  = heap[oneIndex];
            HeapNode nodeTwo = heap[twoIndex];

            heap[oneIndex] = nodeTwo;
            heap[twoIndex] = nodeOne;
        }

        private void trickleDown(int index) {
            int leftChildValue = heap[leftChildIndex(index)].value;
            int rightChildValue = heap[rightChildIndex(index)].value;
            int greaterChildIndex=0 ;

            //Run as long as index is not on the bottom row
            while(index < size/2 ) {
                if (leftChildValue > rightChildValue) {
                    greaterChildIndex = leftChildIndex(index);
                } else {
                    greaterChildIndex = rightChildIndex(index);
                }

                if (heap[index].value > heap[greaterChildIndex].value) {
                    break;
                }
                //swap until we break
            }
            swap(index, greaterChildIndex);
        }

        private void trickleUp(int index) {
            HeapNode nodeToInsert = heap[index];
            int parentIdx = parentIndex(index);
            while(index>0 && heap[parentIdx].value < nodeToInsert.value){
                HeapNode node = heap[index];
                heap[index] = heap[parentIdx];
                index = parentIdx;
                parentIdx = (parentIdx-1)/2;
            }
            heap[index] = nodeToInsert;
        }

        private void ensureCapacity(){
            if (capacity-size <=2){
                heap = Arrays.copyOf(heap, capacity*2);
                capacity *= 2;
            }
        }
    }

    private void maxHeapDataStructure() {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(4);
        heap.insert(5);
        heap.insert(2);
        heap.insert(10);
        heap.insert(9);
        heap.insert(115);
        heap.insert(1);
        System.out.println(Arrays.toString(heap.heap));
    }

    private void swap(int oneIndex, int twoIndex){
        int oneVal  = heapArray[oneIndex];
        int twoVal = heapArray[twoIndex];

        heapArray[oneIndex] = twoVal;
        heapArray[twoIndex] = oneVal;
    }

    private int peek (){
        if (heapSize == 0 ) throw new IllegalStateException("Empty Array");
        return heapArray[0];
    }

    private int poll(){
        if (heapSize == 0 ) throw new IllegalStateException("Empty Array");
        int item = heapArray[0];
        heapArray[0] = heapArray[heapSize-1];
        heapSize --;
        heapifyDown(heapSize);
        return item;
    }

    private void heapifyDown(int index) {
        while (hasLeftChild(index)){
            int minChildIndex = leftChildIndex(index);

            if(hasRightChild(index)){
                if(heapArray[rightChildIndex(index)] < heapArray[leftChildIndex(index)]){
                    minChildIndex = rightChildIndex(index);
                }
            }

            if (heapArray[index] > heapArray[minChildIndex]){
                swap(index,minChildIndex);
            }
            index = minChildIndex;
        }
    }

    private boolean hasRightChild(int parentIndex) {
        return rightChildIndex(parentIndex) > heapSize;
    }


    private int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private int leftChildIndex(int parentIndex) {
        return ( 2 * parentIndex )/2;
    }
    private boolean hasLeftChild(int parentIndex){
        return leftChildIndex(parentIndex) < heapSize;
    }
    private int parentIndex(int childIndex) {
        return (childIndex-1)/2;
    }
    private boolean hasParent(int childIndex) {
        return parentIndex(childIndex) >=0;
    }

    private void add(int item){
        ensureCapacity();

        int index=0;
        if(heapSize>0){
            index = heapSize;
        }
        heapArray[index] = item;
        heapSize++;
        heapifyUp(index);
        System.out.println(Arrays.toString(heapArray));
    }

    private void heapifyUp(int index) {
        while(hasParent(index) && heapArray[parentIndex(index)]>heapArray[index]){
                swap(index,parentIndex(index));
                index = parentIndex(index);
        }
    }


    private void minHeapDataStructure() {
        heapSize = 0;
        heapCapacity = 10;
        heapArray= new int[heapCapacity];
        add(10);
        add(4);
        add(5);
        add(2);
        add(10);
        add(9);
        add(115);
        add(10);
        add(11);
        add(1);

    }


    private void ensureCapacity() {
        if (heapCapacity-heapSize <=2){
            heapArray = Arrays.copyOf(heapArray, heapCapacity*2);
            heapCapacity *= 2;
        }
    }

    public class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data=data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }

        public void printInOrder(){
            if(left!=null){
                left.printInOrder();
            }
            System.out.println(+data+"__");

            if(right!=null){
                right.printInOrder();
            }
        }

        public void insert(int data){
            if(this.data<data){
                if(right==null){
                    right= new Node(data);
                }
                else{
                    right.insert(data);
                }
            }
            else{
                if(left == null){
                    left = new Node(data);
                }
                else{
                    left.insert(data);
                }

            }

        }

        public boolean find(int val) {
            if(data==val){
                return true;
            }
            else{
                if(data>val){
                    if(left!=null){
                        return left.find(val);
                    }
                }
                else{
                    if(right!=null){
                        return right.find(val);
                    }

                }
            }
            return false;
        }
    }

    public void binarySearchTree(int[] array) {
        Node parent = new Node(array[0]);
        for (int i=1;i<array.length;i++){
            parent.insert(array[i]);
        }
        parent.printInOrder();
        boolean found = parent.find(4);
        System.out.println(found);
        Node current = parent;
        int min=current.data;
        while(current.left!=null){
            current=current.left;
            min=current.data;
        }
        System.out.println(min);

        int max = parent.data;
        current = parent;
        while(current.right!=null){
            current=current.right;
            max=current.data;
        }
        System.out.println(max);

    }

    private static void quickSort(int[] array, int start, int end) {
        if(start>=end){
            return;
        }
        int pivot = array[(start+end)/2];
        int index = partition(array,start,end,pivot);
        quickSort(array,start,index-1);
        quickSort(array,index,end);

    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while(left<=right){
            while(array[left]<pivot){
                left++;
            }
            while (array[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void mergeSort(int[] inputArray, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (end+start)/2;
        mergeSort(inputArray,start,mid);
        mergeSort(inputArray,mid+1, end);
        mergeHalves(inputArray,new int[inputArray.length], start, end);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void mergeHalves(int[] array, int[] temp, int start, int end){
        int leftEnd = (end+start)/2;
        int rightStart = leftEnd + 1;
        int size = end - start + 1;


        int left = start;
        int right = rightStart;
        int index = start;

        while(left <= leftEnd && right <= end){
            if(array[left] <= array[right])
            {
                temp[index] = array[left];
                left ++;
            }
            else{
                temp[index] = array[right];
                right++;
            }
            index ++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1 );
        System.arraycopy(array, right, temp, index, end - right + 1 );
        System.arraycopy(temp, start, array, start, size);

    }

}
