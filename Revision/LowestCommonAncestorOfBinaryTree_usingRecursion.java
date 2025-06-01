package Revision;

import Revision.utils.TreeNode;

public class LowestCommonAncestorOfBinaryTree_usingRecursion {
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q || root == null){
            return root;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else {
            return right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode root = new TreeNode(3, node5, node1);

        LowestCommonAncestorOfBinaryTree_usingRecursion lowestCommonAncestorOfBinaryTree = new LowestCommonAncestorOfBinaryTree_usingRecursion();
        System.out.println(lowestCommonAncestorOfBinaryTree.lowestCommonAncestor(root, node7, node1));
    }
}
