package com.ayo.lab4.exercise3;

// Add support method to the SinglyListClass<E> class
public void attach(SinglyLinkedList<E> other) {
    if (this.size == 0) {
        this.head = other.head;
    } else if (other.size != 0) {
        this.tail.setNext(other.head);
    }
    this.tail = other.tail;
    this.size += other.size;

    // Clear the other list
    other.head = null;
    other.tail = null;
    other.size = 0;
}

// Method  of the LinkedQueue<E> class to append LinkedQueue to the end of another LinkedQueue
public void concatenate(LinkedQueue<E> Q2) {
    this.list.attach(Q2.list);
}

