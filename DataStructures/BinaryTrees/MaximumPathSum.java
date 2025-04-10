package DataStructures.BinaryTrees;


//Key Concepts:
//Split vs. Unsplit Path:
//
//A split path includes the current node and both its left and right subtrees.
//An unsplit path includes the current node and only one of its subtrees (left or right).
//The helper function calculates both:
//
//res tracks the maximum split path globally.
//        The return value of helper is the maximum unsplit path starting from the current node.

public class MaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int helper(Node node){
        if(node == null)
            return 0;

        int lSum = Math.max(helper(node.left), 0);
        int rSum = Math.max(helper(node.right), 0);
        res = Math.max(res, node.val + lSum + rSum);

        return node.val + Math.max(lSum, rSum);
    }
    public int maxPathSum(Node root) {
        return Math.max(helper(root), res);
    }

    public static void main(String[] args) {

    }
}
