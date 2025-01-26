package DataStructures.BinaryTrees.CloneBTRandomPointer;

public class NodeWithRandomPointer {
    public int val;
    public NodeWithRandomPointer left;
    public NodeWithRandomPointer right;
    public NodeWithRandomPointer random;

    NodeWithRandomPointer(int data){
        this.val = data;
        this.left = null;
        this.right = null;
        this.random = null;
    }
}
