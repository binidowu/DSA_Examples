package com.ayo.lab7.exercise1;

public class TreeMapSearch {
    private Position<Entry<K,V>> treeSearchNonRecursive(K key) {
        Position<Entry<K,V>> p = root();
        while (isInternal(p)) {
            int comp = compare(key, p.getElement().getKey());
            if (comp == 0) {
                return p; // Key found
            } else if (comp < 0) {
                p = left(p); // Move left
            } else {
                p = right(p); // Move right
            }
        }
        return p; // Return the final leaf (external node) or the node with the key
    }

}
