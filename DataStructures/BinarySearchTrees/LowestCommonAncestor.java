package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class LowestCommonAncestor {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node curr = root;
        while(curr != null){
            if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }
            else if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }
            else{
                return curr;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
