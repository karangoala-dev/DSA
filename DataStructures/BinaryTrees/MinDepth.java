package DataStructures.BinaryTrees;

public class MinDepth {
    public int minDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        return 1 + Math.min(root.left == null ? Integer.MAX_VALUE : minDepth(root.left), root.right == null ? Integer.MAX_VALUE : minDepth(root.right));
    }

    public static void main(String[] args) {
        
    }
}
