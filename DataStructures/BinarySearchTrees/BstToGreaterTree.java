package DataStructures.BinarySearchTrees;

import Revision.utils.TreeNode;

public class BstToGreaterTree {
    public void helper(TreeNode root, int[] currSum){
        if(root == null){
            return;
        }

        helper(root.right, currSum);
        currSum[0] += root.val;
        root.val = currSum[0];
        helper(root.left, currSum);
    }
    public TreeNode convertBST(TreeNode root) {
        helper(root, new int[1]);
        return root;
    }
    public static void main(String[] args) {

    }
}
