package DataStructures.BinaryTrees;

public class InvertBinaryTree {

    //This approach is most optimised and in-place
    public void helper_optimised(BinaryTreePaths.TreeNode node){
        if(node == null){
            return;
        }

        //swap left and right child
        BinaryTreePaths.TreeNode dummy = node.left;
        node.left = node.right;
        node.right = dummy;

        //recurse for each child now
        helper_optimised(node.left);
        helper_optimised(node.right);
    }
    //This approach uses O(N) space
    public void helper(Node a, Node b){
        if(a == null){
            return;
        }

        if(a.left != null){
            //if a has a left child then clone it(only the node, not children) and assign it to right of mirror
            Node left = new Node(a.left.val);
            b.right = left;
        }
        if(a.right != null){
            //if a has a right child then clone it(only the node, not children) and assign it to left of mirror
            Node right = new Node(a.right.val);
            b.left = right;
        }

        //recurse for the children nodes
        helper(a.left, b.right);
        helper(a.right, b.left);
    }
    public Node invertTree(Node root) {
        if(root == null){
            return null;
        }
        Node mirror = new Node(root.val);
        helper(root, mirror);
        return mirror;
    }
    public static void main(String[] args) {

    }
}
