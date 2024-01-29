package com.ayo.lab1.exercise3;

public class CLL {
    /** Main method for testing. */
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        // Add elements to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        try {
            CircularlyLinkedList<Integer> cloneList = list.clone();
            System.out.println("Original list first element: " + list.first());
            System.out.println("Cloned list first element: " + cloneList.first());
            System.out.println();
            System.out.println("Original list last element: " + list.last());
            System.out.println("Cloned list last element: " + cloneList.last());
            // Display more elements or manipulate list as needed to demonstrate cloning
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
