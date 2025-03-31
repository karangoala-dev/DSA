package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.BinaryTreePaths;

public class LowestCommonAncestor_Recursive {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        if(root.val <= q.val && root.val >= p.val){
            return root;
        }

        if(root.val < p.val){
            //Go right
            return helper(root.right, p, q);
        }
        else{
            //Go left
            return helper(root.left, p, q);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = null;
        TreeNode max = null;
        if(p.val <= q.val){
            min = p;
            max = q;
        }
        else{
            min = q;
            max = p;
        }
        return helper(root, min, max);
    }
}
