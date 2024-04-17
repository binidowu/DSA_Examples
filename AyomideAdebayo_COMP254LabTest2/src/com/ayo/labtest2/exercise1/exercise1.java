public class exercise1{
    // Recursive helper method to calculate path length
    private int pathLengthRecursive(Node<E> node, int depth){
        if(node == null)
            return 0;

    // Compute the total path length by summing the depth of the given node
    return depth + pathLengthRecursive(node.getLeft(), depth + 1)
            + pathLengthRecursive(node.getRight(), depth + 1);
    }

    // Calculate the path length of a binary tree
    public int pathLength(){
        return pathLengthRecursive(root, 0);
    }


    // Testing the pathLength method
    public static void main(String[] args){
        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
        Position<Integer> root = binaryTree.addRoot(1);
        Position<Integer> left = binaryTree.addLeft(root, 2);
        Position<Integer> right = binaryTree.addRight(root, 3);
        binaryTree.addLeft(left, 4);
        binaryTree.addRight(left, 5);

        // Calculate and print the path length of the tree
        System.out.println("Path Length of the tree: " + tree.pathLength());
    }
}