package Revision;

import Revision.utils.TreeNode;

public class DeleteNodeInABST {
    //fn to find the target node and it's parent
    TreeNode parent = null;
    public TreeNode findNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            return root;
        }

        if(key < root.val){
            parent = root;
            return findNode(root.left, key);
        }
        else{
            parent = root;
            return findNode(root.right, key);
        }
    }
    //fn to find leftmost node of a tree/subtree
    public TreeNode findLeftmost(TreeNode node){
        if(node == null){
            return null;
        }

        if (node.left == null){
            return node;
        }

        return findLeftmost(node.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            //root to be deleted
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else {
                TreeNode leftMostOfRight = findLeftmost(root.right);
                leftMostOfRight.left = root.left;
                return root.right;
            }
        }

        TreeNode target = findNode(root, key);
        if(target == null){
            //node not found
            return root;
        }
        //now 3 cases -> target has no child/one child/two child
        if(target.left == null && target.right == null){
            if(target.val < parent.val){
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        else if(target.left == null){
            if(target.val < parent.val){
                parent.left = target.right;
            }
            else {
                parent.right = target.right;
            }
        }
        else if (target.right == null) {
            if(target.val < parent.val){
                parent.left = target.left;
            }
            else {
                parent.right = target.left;
            }
        }
        else {
            TreeNode leftMost = findLeftmost(target.right);
            leftMost.left = target.left;
            if(target.val < parent.val){
                parent.left = target.right;
            }
            else {
                parent.right = target.right;
            }
        }

        return root;
    }
    public static void main(String[] args) {

    }
}
