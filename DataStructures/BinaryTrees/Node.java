package DataStructures.BinaryTrees;

public class Node {
    public int val;
    public Node left;
    public Node right;

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public Node(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}
