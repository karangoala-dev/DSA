package DataStructures.BinaryTrees;

public class CountGoodNodes {
    int res = 0;
    public void helper(Node node, int min){
        if(node == null){
            return;
        }
        if(node.val >= min){
            res++;
            min = node.val;
        }
        helper(node.left, min);
        helper(node.right, min);
    }
    public int goodNodes(Node root) {
        helper(root, root.val);
        return res;
    }

    public static void main(String[] args) {
        
    }
}
