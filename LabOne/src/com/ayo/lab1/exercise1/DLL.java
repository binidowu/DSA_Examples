package com.ayo.lab1.exercise1;

public class DLL {
    /** Main method for testing. */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();

        // Add elements to L and M
        for (int i = 0; i < 5; i++) { L.addLast(i); }
        for (int i = 5; i < 11; i++) { M.addLast(i); }

        // Concatenate L and M
        L.concat(M);

        // Print the concatenated list
        System.out.println("Concatenated List Elements: ");
        L.display();

    }
}
