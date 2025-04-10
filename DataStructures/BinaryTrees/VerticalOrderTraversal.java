package DataStructures.BinaryTrees;

import java.util.*;

public class VerticalOrderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, List<int[]>> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashSet<Integer> visitedCols = new HashSet<>();
    //fn to populate the map
    public void traverse(TreeNode node, int r, int c){
        if(node == null)
            return;
        map.putIfAbsent(c, new ArrayList<>());
        map.get(c).add(new int[]{r, node.val});

        if(!visitedCols.contains(c)){
            visitedCols.add(c);
            pq.add(c);
        }

        traverse(node.left, r + 1, c - 1);
        traverse(node.right, r + 1, c + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        // printGraph(map);
        while(!pq.isEmpty()){
            int currentCol = pq.poll();
            List<int[]> rowAndNode = map.get(currentCol);
            //sort acc to row is row not equal, else according to value
            rowAndNode.sort((o1, o2)->o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            List<Integer> curr = new ArrayList<>();

            for(int[] pair: rowAndNode){
                curr.add(pair[1]);
            }
            res.add(curr);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
