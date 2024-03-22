package com.ayo.labfive.exercise3;

public class UpHeap {
    protected void upheap(int j) {
        if (j == 0) return; // Base case: The root of the heap has no parent to swap with.

        int p = parent(j);
        if (compare(heap.get(j), heap.get(p)) < 0) { // If the current node is less than its parent, swap them.
            swap(j, p);
            upheap(p); // Recursive call to continue the process from the parent's location.
        }
        // If the current node is not less than its parent, the heap-order property is restored.
    }
}
