package DataStructures.BinarySearchTrees;

public class RecoverBST_optimised {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        //if we found a non-increasing sequence here
        if(prev.val > node.val){
            //if first is null, then assign prev ka value to first and current node to middle
            if(first == null){
                first = prev;
                middle = node;
            }
            else{
                //if non adjacent nodes then it will come here.
                last = node;
            }
        }
        prev = node;
        inorder(node.right);
    }
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        first = middle = last = null;
        inorder(root);
        //if last is null, means first and middle to be swapped
        if(last == null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        //else first and last to be swapped
        else{
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }

    public static void main(String[] args) {

    }
}
