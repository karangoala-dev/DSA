package DataStructures.BinaryTrees;

public class InvertBinaryTree {
    public void helper(Node a, Node b){
        if(a == null){
            return;
        }

        if(a.left != null){
            Node left = new Node(a.left.val);
            b.right = left;
        }
        if(a.right != null){
            Node right = new Node(a.right.val);
            b.left = right;
        }

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
