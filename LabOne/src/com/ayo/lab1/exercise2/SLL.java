package com.ayo.lab1.exercise2;

public class SLL {
    /** Main method for testing. */
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Add elements and get references to nodes for swapping
        list.addLast(1); // Method to add element and return the new node
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // Display the list before swapping
        System.out.println("List before swapping:");
        list.display();

        // Swap the nodes
        list.swap(1, 4);

        // Display the list after swapping
        System.out.println("List after swapping:");
        list.display();
    }
}
