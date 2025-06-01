package Revision;

import Revision.utils.TreeNode;

public class MaximumDiameterOfBinaryTree {
    int res = Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        //consider current node as the node with max diameter path's root node
        res = Math.max(res, left + right);

        //return the max depth at each node
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    public static void main(String[] args) {
        MaximumDiameterOfBinaryTree maximumDiameterOfBinaryTree = new MaximumDiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        System.out.println(maximumDiameterOfBinaryTree.diameterOfBinaryTree(root));;
    }
}
