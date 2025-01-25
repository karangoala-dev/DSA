package DataStructures.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> dummy = new LinkedList<>();
        dummy.offer(root);
        while(dummy.size() != 0){
            int n = dummy.size();
            for(int i = 0; i < n; i++){
                Node curr = dummy.poll();
                if(curr.left != null){
                    dummy.offer(curr.left);
                }
                if(curr.right != null){
                    dummy.offer(curr.right);
                }

                if(i == n - 1){
                    res.add(curr.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
