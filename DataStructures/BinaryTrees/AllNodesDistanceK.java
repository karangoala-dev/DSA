package DataStructures.BinaryTrees;

import java.util.*;

public class AllNodesDistanceK {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public void createGraph(TreeNode node){
        if(node == null){
            return;
        }

        graph.putIfAbsent(node.val, new ArrayList<>());
        if(node.left != null){
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.val).add(node.left.val);
            graph.get(node.left.val).add(node.val);
            createGraph(node.left);
        }
        if(node.right != null){
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.val).add(node.right.val);
            graph.get(node.right.val).add(node.val);
            createGraph(node.right);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createGraph(root);
        Queue<Integer> q = new LinkedList<>();
        q.add(target.val);
        List<Integer> res = new ArrayList<>();
        int d = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        while(!q.isEmpty()){
            if(d == k){
                while(!q.isEmpty()){
                    res.add(q.poll());
                }
                break;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int nei: graph.get(curr)){
                    if(!visited.contains(nei)){
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
            d++;
        }
        return res;
    }
    public void printGraph(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

    }
}
