package com.ayo.lab4.exercise1;


public int indexOf(Position<E> p) {
    int index = 0;
    for (Position<E> current = first(); current != null; current = after(current)) {
        if (current == p) {
            return index;
        }
        index++;
    }
    return -1; // position not found
}

