package DataStructures.BinarySearchTrees;

public class DeleteNodeInABST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    TreeNode parent = null;
    public TreeNode findNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            return root;
        }
        if(key < root.val){
            //go left
            parent = root;
            return findNode(root.left, key);
        }
        else{
            //go right
            parent = root;
            return findNode(root.right, key);
        }
    }
    public TreeNode findLeftMost(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null){
            return root;
        }

        return findLeftMost(root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = findNode(root, key);
        if(target == null)
            return root;
        if(key == root.val){
            //means root node to be deleted
            TreeNode leftMost = findLeftMost(root.right);
            if(leftMost == null){
                //means right child of root is null
                return root.left;
            }
            //else
            leftMost.left = root.left;

            return root.right;
        }
        //now 3 cases, node to be deleted has one child, 2 children or no children
        if(target.left == null && target.right == null){
            if(target.val < parent.val){
                //delete left
                parent.left = null;
            }
            else{
                //delete right
                parent.right = null;
            }
        }
        else if(target.left == null){
            //attach targets' right to parent
            if(target.val < parent.val){
                parent.left = target.right;
            }
            else{
                parent.right = target.right;
            }
        }
        else if(target.right == null){
            //attach targets' left to parent
            if(target.val < parent.val){
                parent.left = target.left;
            }
            else{
                parent.right = target.left;
            }
        }
        else{
            //means both left and right children present
            //attach the target.right to parent and target.left to leftmost of right
            TreeNode leftMost = findLeftMost(target.right);
            if(target.val < parent.val){
                parent.left = target.right;
            }
            else{
                parent.right = target.right;
            }
            leftMost.left = target.left;
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
