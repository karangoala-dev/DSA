package DataStructures.BinaryTrees;

public class Diameter {
    public int currentMax = Integer.MIN_VALUE;
    public int helper(Node node){
        if(node == null){
            return -1;
        }
        if(node.left == null && node.right == null){
            currentMax = Math.max(currentMax, 0);
            return 0;
        }
        int leftSide = helper(node.left);
        int rightSide = helper(node.right);
        currentMax = Math.max(currentMax, 2 + leftSide + rightSide);
        return 1 + Math.max(leftSide, rightSide);
    }
    public int diameterOfBinaryTree(Node root) {
        helper(root);
        return currentMax;
    }

    public static void main(String[] args) {

    }
}
