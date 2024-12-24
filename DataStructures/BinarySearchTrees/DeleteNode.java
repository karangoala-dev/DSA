package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class DeleteNode {
    public Node helper(Node node){
        if(node.left == null){
            return node.right;
        }
        else if(node.right == null){
            return node.left;
        }
        Node lastRight = findLastRightOfLeft(node.left);
        lastRight.right = node.right;
        return node.left;
    }
    public Node findLastRightOfLeft(Node node){
        if(node.right == null){
            return node;
        }
        return findLastRightOfLeft(node.right);
    }
    public Node deleteNode(Node root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            return helper(root);
        }
        Node ptr = root;
        while(ptr != null){
            if(key < ptr.val){
                if(ptr.left != null && ptr.left.val == key){
                    ptr.left = helper(ptr.left);
                }
                else{
                    ptr = ptr.left;
                }
            }
            else{
                if(ptr.right != null && ptr.right.val == key){
                    ptr.right = helper(ptr.right);
                }
                else{
                    ptr = ptr.right;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
