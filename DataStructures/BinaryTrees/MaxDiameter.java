package DataStructures.BinaryTrees;

public class MaxDiameter {
    private int maxDiameter = 0;
    public int helper(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(Node root) {
        helper(root);
        return maxDiameter;
    }

    public static void main(String[] args) {

    }
}
