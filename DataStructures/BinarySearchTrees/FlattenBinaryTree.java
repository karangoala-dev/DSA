package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class FlattenBinaryTree {
    public Node helper(Node node, Node prev){
        if(node == null){
            return prev;
        }

        prev = helper(node.right, prev);
        prev = helper(node.left, prev);

        node.left = null;
        node.right = prev;
        prev = node;

        return prev;
    }

    public void flatten(Node root) {
        helper(root, null);
    }

    public static void main(String[] args) {

    }
}
