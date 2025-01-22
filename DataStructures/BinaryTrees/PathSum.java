package DataStructures.BinaryTrees;

public class PathSum {
    public boolean helper(Node root, int targetSum, int curr){
        if(root.left == null && root.right == null){
            if(curr + root.val == targetSum){
                return true;
            }
            return false;
        }
        curr += root.val;
        boolean left = false;
        boolean right = false;
        if(root.left != null){
            left = helper(root.left, targetSum, curr);
        }
        if(root.right != null){
            right = helper(root.right, targetSum, curr);
        }
        curr -= root.val;
        return left || right;
    }
    public boolean hasPathSum(Node root, int targetSum) {
        if(root == null)
            return false;
        return helper(root, targetSum, 0);
    }
    public static void main(String[] args) {

    }
}
