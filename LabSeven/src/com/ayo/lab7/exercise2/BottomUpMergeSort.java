package com.ayo.lab7.exercise2;

public class BottomUpMergeSort {
    public static <E> void mergeSort(Queue<E> S, Comparator<E> comp) {
        Queue<Queue<E>> Q = new LinkedQueue<>();
        // Initialize: Place each element into its own queue
        while (!S.isEmpty()) {
            Queue<E> singleElementQueue = new LinkedQueue<>();
            singleElementQueue.enqueue(S.dequeue());
            Q.enqueue(singleElementQueue);
        }
        // Merge process
        while (Q.size() > 1) {
            Queue<E> S1 = Q.dequeue();
            Queue<E> S2 = Q.dequeue();
            Queue<E> merged = new LinkedQueue<>();
            merge(S1, S2, merged, comp);
            Q.enqueue(merged);
        }
        // Move back to original queue
        if (!Q.isEmpty()) {
            Queue<E> sorted = Q.dequeue();
            while (!sorted.isEmpty()) {
                S.enqueue(sorted.dequeue());
            }
        }
    }
}
