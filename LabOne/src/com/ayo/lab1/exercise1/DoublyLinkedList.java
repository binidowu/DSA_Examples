package com.ayo.lab1.exercise1;

public class DoublyLinkedList<E> {
    /** A basic doubly linked list implementation. */
    //---------- nested Node class ---------
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p;}
        public void setNext(Node<E> n) { next = n;}
    } // end of nested Node class

    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    /** Constructs an empty list. */
    public DoublyLinkedList() {
        header = new Node<E>(null, null, null); // create header
        trailer = new Node<E>(null, header, null); // trailer is preceded by header
        header.setNext(trailer);
    }

    /** Returns the number of elements in the linked list */
    public int size() { return size; }

    /** Test whether the linked list is empty */
    public boolean isEmpty() { return size == 0; }

    /** Returns (but does not remove) the first element in the list. */
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement(); // first element of the list
    }

    /** Returns (but does not remove) the last element in the list. */
    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement(); // last element before the trailer
    }
    // private update methods
    /** Adds element e to the linkes list in between the given nodes. */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /** Removes the given node from the list and returns its element. */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // public update methods
    /** Adds element e to the front of the list. */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    /** Adds element e to the end of the list. */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    /** Removes and returns the first element in the list. */
    public E removeFirst() {
        if(isEmpty()) return null;  // nothing to remove
        return remove(header.getNext()); // first element is beyond the header
    }

    /** Removes and returns the last element in the list. */
    public E removeLast() {
        if(isEmpty()) return null;      // nothing to remove
        return remove(trailer.getPrev());   // last element is before the trailer
    }

    /** Concatenate two given doubly linked lists. */
    public void concat(DoublyLinkedList<E> secondList) {
        if(secondList.isEmpty()) return; // nothing to concatenate

        Node<E> secondListFirstNode = secondList.header.getNext();
        Node<E> secondListLastNode = secondList.trailer.getPrev();
        Node<E> firstListLastNode = this.trailer.getPrev();


        secondListFirstNode.setPrev(firstListLastNode); // link the second list's first node  to the first list's last node
        firstListLastNode.setNext(secondListFirstNode); // link the second list's last node to the  first list's first node

        this.trailer.setPrev(secondListLastNode); // link the first list's last node to the second list's last node
        secondListLastNode.setNext(this.trailer); // link the second list's last node to the first list trailer

        size += secondList.size(); // add the number of elements in the second list to the total
    }

    /** Method to display the contents of the linked list. */
    public void display() {
        Node<E> current = header.getNext();
        while(current!= trailer) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

} // ---------------- end of DoublyLinkedList class ----------------