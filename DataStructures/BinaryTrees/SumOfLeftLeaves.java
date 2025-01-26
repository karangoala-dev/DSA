package DataStructures.BinaryTrees;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(Node root) {
        if(root == null){
            return 0;
        }

        int res = 0;

        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                res += root.left.val;
            }
            else{
                res += sumOfLeftLeaves(root.left);
            }
        }

        if(root.right != null){
            if(root.right.left != null || root.right.right != null){
                res += sumOfLeftLeaves(root.right);
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
