package Revision.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int _v){
        this.val = _v;
    }

    public TreeNode(int _v, TreeNode _l, TreeNode _r){
        this.val = _v;
        this.left = _l;
        this.right = _r;
    }

    @Override
    public String toString() {
        return "val=" + val + " ";
    }
}
