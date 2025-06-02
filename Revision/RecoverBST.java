package Revision;

import Revision.utils.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {
    List<Integer> inorder = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }

    public void helper(TreeNode root, int[] ind){
        if(root == null){
            return;
        }

        helper(root.left, ind);
        if(root.val != inorder.get(ind[0])){
            root.val = inorder.get(ind[0]);
        }
        ind[0]++;
        helper(root.right, ind);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(inorder);
        helper(root, new int[]{0});
    }
    public static void main(String[] args) {

    }
}
