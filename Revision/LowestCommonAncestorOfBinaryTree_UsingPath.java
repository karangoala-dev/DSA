package Revision;

import Revision.utils.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfBinaryTree_UsingPath {
    public boolean getPath(TreeNode root, TreeNode target, List<TreeNode> curr){
        if(root == null){
            return false;
        }
        if(root == target){
            curr.add(root);
            return true;
        }

        //add current node to path
        curr.add(root);

        //recurse on left and right
        boolean r1 = getPath(root.left, target, curr);
        boolean r2 = getPath(root.right, target, curr);

        //backtrack if not found
        if(!r1 && !r2){
            curr.remove(curr.size() - 1);
            return false;
        }

        //we reach here means one of the r1 or r2 was true, so return true;
        return true;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //get paths for p and q
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        getPath(root, p, pPath);
        getPath(root, q, qPath);

        TreeNode res = null;
        int i = 0;
        while(i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)){
            res = pPath.get(i);
            i++;
        }

        return res;
    }
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode root = new TreeNode(3, node5, node1);

        LowestCommonAncestorOfBinaryTree_UsingPath lowestCommonAncestorOfBinaryTree = new LowestCommonAncestorOfBinaryTree_UsingPath();
        System.out.println(lowestCommonAncestorOfBinaryTree.lowestCommonAncestor(root, node7, node1));
    }
}
