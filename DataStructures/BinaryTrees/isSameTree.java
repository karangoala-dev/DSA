package DataStructures.BinaryTrees;

public class isSameTree {
    public boolean isSameTree(Node p, Node q) {
        if(p == null || q == null){
            if(p != null || q != null){
                return false;
            }
            return true;
        }
        if(p.val != q.val){
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);

        return l & r;
    }

    public static void main(String[] args) {

    }
}
