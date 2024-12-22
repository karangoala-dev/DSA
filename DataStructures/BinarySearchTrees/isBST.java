package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class isBST {
    public boolean helper(Node node, int max, int min, boolean hasMin, boolean hasMax){
        if(node == null){
            return true;
        }

        if((hasMin && node.val <= min) || (hasMax && node.val >= max)){
            return false;
        }

        return helper(node.left, node.val, min, hasMin, true) && helper(node.right, max, node.val, true, hasMax);
    }
    public boolean isValidBST(Node root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, false, false);
    }

    public static void main(String[] args) {

    }
}
