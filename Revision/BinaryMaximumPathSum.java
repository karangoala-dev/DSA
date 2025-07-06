package Revision;

import Revision.utils.TreeNode;

public class BinaryMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        //compare if we should take or not take a sub-tree
        int lSum = Math.max(helper(node.left), 0);
        int rSum = Math.max(helper(node.right), 0);
        //set res if current node , left and right sub trees are part of max path
        res = Math.max(res, node.val + lSum + rSum);

        //return the sum of current node and max out of left and right sub tree path
        return node.val + Math.max(lSum, rSum);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public static void main(String[] args) {

    }
}
