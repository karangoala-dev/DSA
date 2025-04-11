package DataStructures.BinarySearchTrees;

import java.util.*;

public class GenerateBST2 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<TreeNode> generate(int left, int right){
        if(left == right){
            //if only one node, return it
            return new ArrayList<>(Arrays.asList(new TreeNode(left)));
        }
        if(left > right){
            TreeNode dummy = null;
            return new ArrayList<>(Arrays.asList(dummy));
        }

        List<TreeNode> res = new ArrayList<>();
        for(int val = left; val <= right; val++){
            //get subtrees for the left values and right values.
            List<TreeNode> leftTrees = generate(left, val - 1);
            List<TreeNode> rightTrees = generate(val + 1, right);
            //attach each left and right subtree respectively
            for(TreeNode leftSubtree: leftTrees){
                for(TreeNode rightSubtree: rightTrees){
                    TreeNode root = new TreeNode(val);
                    root.left = leftSubtree;
                    root.right = rightSubtree;

                    res.add(root);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public static void main(String[] args) {

    }
}
