package DataStructures.BinaryTrees;

public class MaxDiameter {
    //For this qn, we need to check 2 things.
    //1.Max depth at each node
    //2.Max diameter at each node
    private int maxSoFar = Integer.MIN_VALUE;
    public int helper(Node node){
        if(node == null){
            //If node is null return -1 to make the result in parent node's call = 0
            maxSoFar = Math.max(maxSoFar, 0);
            return -1;
        }
        if(node.left == null && node.right == null){
            maxSoFar = Math.max(maxSoFar, 0);
            return 0;
        }
        //Get left depth and right depth.
        int leftDepth = 1 + helper(node.left);
        int rightDepth = 1 + helper(node.right);

        //MaxSoFar is the max diameter so far
        maxSoFar = Math.max(maxSoFar, (leftDepth + rightDepth));

        //Here we return the max depth for this node.
        return Math.max(leftDepth, rightDepth);

    }
    public int diameterOfBinaryTree(Node root) {
        helper(root);
        return maxSoFar;
    }

    public static void main(String[] args) {

    }
}
