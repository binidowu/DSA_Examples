package com.ayo.labfive.exercise2;

public class TreeHeight {
    // Method to compute and print the height of each subtree
    public int computeAndPrintHeight(Position<E> p) {

        if (p == null) {
            return -1;
        }

        Node<E> node = validate(p); // Perform validation only once for the external call.

        // Compute the height of the left subtree
        int leftHeight = (node.getLeft() == null) ? -1 : computeAndPrintHeight(node.getLeft());
        // Compute the height of the right subtree
        int rightHeight = (node.getRight() == null) ? -1 : computeAndPrintHeight(node.getRight());

        // Calculate the node's height as the maximum of the heights of its left and right children, plus one
        int nodeHeight = 1 + Math.max(leftHeight, rightHeight);

        // Print the element and height
        System.out.println("Node Value: " + node.getElement() + ", Subtree Height: " + nodeHeight);

        // Return the node's height
        return nodeHeight;
    }
}
