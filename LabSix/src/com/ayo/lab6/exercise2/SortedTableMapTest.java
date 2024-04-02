package com.ayo.lab6.exercise2;

public class SortedTableMapTest {
    public boolean containsKey(K key) {
        int j = findIndex(key);
        if (j < size() && compare(key, table.get(j)) == 0) { // check if index is within bounds and keys match
            return true;
        }
        return false;
    }
}