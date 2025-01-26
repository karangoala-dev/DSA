package DataStructures.BinaryTrees;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(Node root) {
        if(root == null){
            return 0;
        }

        int res = 0;

        if(root.left != null){
            // if left side is a leaf, then add val else continue on the left node.
            if(root.left.left == null && root.left.right == null){
                res += root.left.val;
            }
            else{
                res += sumOfLeftLeaves(root.left);
            }
        }

        if(root.right != null){
            // Now , if right is a leaf, no need to continue, if it is not a leaf then continue on the right node.
            if(root.right.left != null || root.right.right != null){
                res += sumOfLeftLeaves(root.right);
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
