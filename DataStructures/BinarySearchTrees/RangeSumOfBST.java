package DataStructures.BinarySearchTrees;

public class RangeSumOfBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int helper(TreeNode node, int l, int h){
        if(node == null){
            return 0;
        }

        if(node.val > h){
            //go left to find smaller elements
            return helper(node.left, l, h);
        }
        else if(node.val < l){
            //go right to find larger elements
            return helper(node.right, l, h);
        }

        //if we reach here, it means node val is between l and h, so add and recurse
        return node.val + helper(node.left, l, h) + helper(node.right, l, h);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    public static void main(String[] args) {

    }
}
