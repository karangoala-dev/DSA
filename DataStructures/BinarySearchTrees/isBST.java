package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

import java.util.LinkedList;
import java.util.List;

public class isBST {
    //Approach #1 using recursion
    public boolean helper(Node node, int max, int min, boolean hasMin, boolean hasMax){
        if(node == null){
            return true;
        }

        if((hasMin && node.val <= min) || (hasMax && node.val >= max)){
            return false;
        }

        return helper(node.left, node.val, min, hasMin, true) && helper(node.right, max, node.val, true, hasMax);
    }
    public boolean isValidBST_recursive(Node root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, false, false);
    }
    
    //Approach #2 using inorder traversal
    List<Integer> inorder = new LinkedList<>();
    public void inorderTraversal(Node node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }
    public boolean isValidBST(Node root) {
        inorderTraversal(root);
        for(int i = 1; i < inorder.size(); i++){
            if(inorder.get(i) <= inorder.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
