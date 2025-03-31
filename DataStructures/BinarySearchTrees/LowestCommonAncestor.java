package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class LowestCommonAncestor {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node curr = root;
        while(curr != null){
            if(p.val > curr.val && q.val > curr.val){
                //If both values are strictly greater go right
                curr = curr.right;
            }
            else if(p.val < curr.val && q.val < curr.val){
                //If both values are strictly smaller, go left
                curr = curr.left;
            }
            else{
                //return curr for other cases where curr might be p or q or curr has a value between p and q
                return curr;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
