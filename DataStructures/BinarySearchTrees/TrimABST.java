package DataStructures.BinarySearchTrees;

import Revision.utils.TreeNode;

public class TrimABST {
    public TreeNode helper(TreeNode root, int l, int h){
        if(root == null){
            return null;
        }
        if(root.val < l){
            //means all nodes on left of root are also smaller, so return trimmed right subtree
            return helper(root.right, l, h);
        }
        if(root.val > h){
            //means all nodes on right of root are also greater, so return trimmed left subtree
            return helper(root.left, l, h);
        }

        root.left = helper(root.left, l, h);
        root.right = helper(root.right, l, h);

        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    public static void main(String[] args) {

    }
}
