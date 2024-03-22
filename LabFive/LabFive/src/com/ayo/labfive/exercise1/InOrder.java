package com.ayo.labfive.exercise1;

public class InOrder {
    // method to find the inorder successor of a given node
    public Position<E> inorderTraversal(Position<E> p) {
        // Validate node as an instance of the inner node class(Validate method is from code example)
        Node<E> node = validate(p);

        // If right child exists, go deep to the leftmost node in right subtree
        if (node.getRight() != null) {
            Node<E> temp = node.getRight();
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp;
        }

        // No right child exists, move up to find the ancestor which is left child of its parent
        Node<E> parent = node.getParent();
        while (parent != null && node == parent.getRight()) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }
}
