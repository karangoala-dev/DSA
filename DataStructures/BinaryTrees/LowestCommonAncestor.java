package DataStructures.BinaryTrees;

public class LowestCommonAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if both are not null, return root as it means, left and right of root have one of each
        if(left != null && right != null){
            return root;
        }

        //else it means, one of the node on one side is the LCA
        return left == null ? right : left;
    }

    public static void main(String[] args) {

    }
}
