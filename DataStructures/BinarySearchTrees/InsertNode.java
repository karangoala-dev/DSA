package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class InsertNode {
    public Node insertIntoBST(Node root, int val) {
        if(root == null){
            return new Node(val);
        }
        Node dummy = root;
        while(dummy != null){
            if(dummy.val > val){
                //node to be inserted on left side
                if(dummy.left == null){
                    dummy.left = new Node(val);
                    break;
                }
                else{
                    dummy = dummy.left;
                }
            }
            else{
                // node to be inserted on right side
                if(dummy.right == null){
                    dummy.right = new Node(val);
                    break;
                }
                else{
                    dummy = dummy.right;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
