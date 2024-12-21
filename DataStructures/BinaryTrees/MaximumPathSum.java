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
    public int res = 0;
    public int helper(Node node){
        if(node == null){
            return 0;
        }

        int l = Math.max(helper(node.left), 0);
        int r = Math.max(helper(node.right), 0);

        // Max sum with split
        res = Math.max(res, node.val + l + r);

        //Return unsplitted value
        return node.val + Math.max(l, r);
    }
    public int maxPathSum(Node root) {
        res = root.val;
        helper(root);
        return res;
    }

    public static void main(String[] args) {

    }
}
