package DataStructures.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> inorder = new ArrayList<>();
    public void helper(TreeNode node, int[] ind){
        if(node == null){
            return;
        }
        helper(node.left, ind);
        if(node.val != inorder.get(ind[0])){
            node.val = inorder.get(ind[0]);
        }
        ind[0]++;
        helper(node.right, ind);
    }

    public void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        inorder.add(node.val);
        inorder(node.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        inorder = inorder.stream().sorted().toList();
        helper(root, new int[] {0});
    }

    public static void main(String[] args) {

    }
}
