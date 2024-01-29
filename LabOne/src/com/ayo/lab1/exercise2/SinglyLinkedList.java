package com.ayo.lab1.exercise2;

public class SinglyLinkedList<E> {
    //---------- nested Node class ---------
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

    //instance variable of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    }    // constructs an initially empty list

    // accessor methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {  // returns (but does not remove) the first element in the list
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element in the list
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) { // adds the specified element to the beginning of the list
        head = new Node<>(e, head);  // create a new node and link it to the head of the list
        if (size == 0) tail = head;  // if the list is empty, set the tail to be the new node
        size++;
    }

    public void addLast(E e) { // adds the specified element to the end of the list
        Node<E> newest = new Node<>(e, null); // create a new node and link it to the tail of the list
        if (isEmpty())
            head = newest;      // if the list is empty, set the head to be the new node
        else
            tail.setNext(newest);  // mew node after existing tail
        tail = newest;      //  set the new node's next to be the tail of the list
        size++;
    }

    public E removeFirst() { // removes and returns the first element in the list
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null;
        return answer;
    }


    // operations

    /**
     * Swap two nodes in the linked list.
     */
    public void swap(E element1, E element2) {
        // If the elements are the same, no swap is needed
        if (element1.equals(element2)) return;

        // Track the current and previous nodes
        Node<E> node1 = null, node2 = null, prev1 = null, prev2 = null, current = head;

        // Traverse the list to find node1 and node2 based on their elements
        while (current != null) {
            if (current.getElement().equals(element1))
                node1 = current;
            else if (current.getElement().equals(element2))
                node2 = current;

            if (node1 == null) prev1 = current;
            if (node2 == null) prev2 = current;

            current = current.getNext();
        }

        // If either node was not found, do not perform the swap
        if (node1 == null || node2 == null) return;

        // If one of the nodes to swap is the head of the list
        if (node1 == head)
            head = node2;
        else if (node2 == head)
            head = node1;

        // If one of the nodes to swap is the tail of the list
        if (node1 == tail)
            tail = node2;
        else if (node2 == tail)
            tail = node1;

        // Swap the previous nodes' next references
        if (prev1 != null) prev1.setNext(node2);
        if (prev2 != null) prev2.setNext(node1);

        // Swap the next references of the nodes themselves
        Node<E> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
    }


    /**
     * Displays the elements of the list.
     */
    public void display() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


}
