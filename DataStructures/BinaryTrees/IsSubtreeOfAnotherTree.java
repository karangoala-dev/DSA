package DataStructures.BinaryTrees;

public class IsSubtreeOfAnotherTree {
    public boolean compare(Node a, Node b){
        if(a == null || b == null){
            if(a != null || b != null){
                return false;
            }
            return true;
        }

        if(a.val != b.val){
            return false;
        }

        boolean left = compare(a.left, b.left);
        boolean right = compare(a.right, b.right);

        return left && right;
    }
    public boolean isSubtree(Node a, Node b) {
        if(a == null || b == null){
            if(a != null || b != null){
                return false;
            }
            return true;
        }

        if(a.val == b.val){
            boolean res = compare(a, b);
            if(res == true){
                return true;
            }
        }

        boolean res1 = isSubtree(a.left, b);
        boolean res2 = isSubtree(a.right, b);

        return res1 || res2;
    }
    public static void main(String[] args) {
        // Call the isSubtree fn now
    }
}
