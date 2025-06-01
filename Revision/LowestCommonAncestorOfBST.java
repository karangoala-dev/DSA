package Revision;

import Revision.utils.TreeNode;

public class LowestCommonAncestorOfBST {
    public TreeNode helper(TreeNode root, int min, int max){
        if(root == null){
            return root;
        }
        if(root.val >= min && root.val <= max){
            return root;
        }

        //we reach here means root is not between min and max
        if(root.val > max){
            //travel left
            return helper(root.left, min, max);
        }
        else {
            //travel right
            return helper(root.right, min, max);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        return helper(root, min, max);
    }
    public static void main(String[] args) {

    }
}
