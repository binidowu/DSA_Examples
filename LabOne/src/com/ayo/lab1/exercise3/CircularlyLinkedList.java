package com.ayo.lab1.exercise3;


public class CircularlyLinkedList<E> implements Cloneable{
    private static class Node<E> {
        // instance variables
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the next node in the list

        // constructor
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // getters and setters
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } //-------- end of nested Node class ---------

    //instance variable of the CircularlyLinkedList
    private Node<E> tail = null;        // we store tail(but not head)
    private int size = 0;            // number of nodes in the list

    public CircularlyLinkedList() {
    } // constructs an initially empty list

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {  // returns (but does not remove) the first element in the list
        if (isEmpty()) return null;
        return tail.getNext().getElement();     // the head is *after*  the tail
    }

    public E last() { // returns (but does not remove) the last element in the list
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void rotate() {       // rotate the first element to the back of the list
        if (tail == null)        // if empty, do nothing
            tail = tail.getNext();       // the old head becomes the new tail
    }

    public void addFirst(E e) { // adds the specified element to the beginning of the list
        if (size == 0) {

            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {      // adds element e to the end of the list
        addFirst(e);                // insert new element at front of list
        tail = tail.getNext();      // now new element becomes the tail
    }

    public E removeFirst() {       // removes and returns the first element
        if (isEmpty()) return null;        // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail)           // must be the only node left
            tail = null;
        else
            tail.setNext(head.getNext());   // removes ”head” from the list
        size--;
        return head.getElement();
    }

    /** Returns the clone of the list. */
    @Override
    public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone(); // safe cast
        if (size > 0) { // we need independent chain of nodes
            other.tail = new Node<>(tail.getElement(), null); // Create a new node for tail
            Node<E> walk = tail.getNext(); // walk through remainder of original list
            Node<E> otherTail = other.tail; // remember most recently created node
            do {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            } while (walk != tail.getNext()); // Make sure to loop back to the beginning of the list

            otherTail.setNext(other.tail); // Correctly link the last node to the head of the new list
        }
        return other;
    }
}
