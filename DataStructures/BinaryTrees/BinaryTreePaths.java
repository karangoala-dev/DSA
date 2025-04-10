package DataStructures.BinaryTrees;

import java.util.*;

public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res;
    public void helper(TreeNode node, List<Integer> path){
        if(node == null){
            return;
        }
        //If it is a leaf node
        if(node.left == null && node.right == null){
            int previousSize = path.size();
            path.add(node.val);
            res.add(new ArrayList<>(path));
            path.remove(previousSize);
            return;
        }
        int previousSize = path.size();
        path.add(node.val);
        helper(node.left, path);
        helper(node.right, path);
        path.remove(previousSize);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, path);
        List<String> result = new ArrayList<>();
        for(List<Integer> currentPath: res){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < currentPath.size(); i++){
                sb.append(currentPath.get(i));
                if(i != currentPath.size() - 1){
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
