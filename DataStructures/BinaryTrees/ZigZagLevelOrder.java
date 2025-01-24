package DataStructures.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> dummy = new LinkedList<>();
        dummy.offer(root);
        boolean isLeftToRight = true;
        while(dummy.size() != 0){
            int n = dummy.size();
            LinkedList<Integer> currentList = new LinkedList<>();
            while(n != 0){
                Node curr = dummy.poll();

                if(isLeftToRight == true){
                    currentList.addLast(curr.val);
                }
                else{
                    currentList.addFirst(curr.val);
                }

                if(curr.left != null){
                    dummy.offer(curr.left);
                }
                if(curr.right != null){
                    dummy.offer(curr.right);
                }

                n--;
            }
            res.add(currentList);
            isLeftToRight = !isLeftToRight;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
