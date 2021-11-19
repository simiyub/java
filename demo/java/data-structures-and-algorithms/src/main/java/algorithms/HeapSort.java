package algorithms;

import java.util.concurrent.ConcurrentHashMap;

public interface HeapSort <E extends Comparable<E>>extends Sort {

    E[] maxHeapify(E[] array, Integer node, Integer heapLength);



}
