package DataStructures.BinaryTrees;

import java.util.*;

public class Test {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void generatePath(TreeNode root, TreeNode t, List<TreeNode> path){
        if(root == null){
            return;
        }
        if(root == t){
            path.add(root);
            return;
        }
        path.add(root);
        generatePath(root.left, t, path);
        generatePath(root.right, t, path);
        path.remove(root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        generatePath(root, p, pPath);
        generatePath(root, q, qPath);
        System.out.println(pPath.toArray());
        System.out.println(qPath.toArray());
        return null;
    }
    public static void main(String[] args) {

    }
}
