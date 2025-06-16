package Revision;

import java.util.*;
import Revision.utils.*;

public class AllNodesAtDistanceK {
    List<Integer> res = new ArrayList<>();
    public void createGraph(HashMap<Integer, List<Integer>> graph, TreeNode node){
        if(node == null){
            return;
        }
        if(!graph.containsKey(node.val)){
            graph.put(node.val, new ArrayList<>());
        }
        createGraph(graph, node.left);
        if (node.left != null) {
            graph.get(node.val).add(node.left.val);
            if(!graph.containsKey(node.left.val)){
                graph.put(node.left.val, new ArrayList<>());
            }
            graph.get(node.left.val).add(node.val);
        }
        if (node.right != null) {
            graph.get(node.val).add(node.right.val);
            if(!graph.containsKey(node.right.val)){
                graph.put(node.right.val, new ArrayList<>());
            }
            graph.get(node.right.val).add(node.val);
        }
        createGraph(graph, node.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(graph, root);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(target.val);
        visited.add(target.val);

        while (!q.isEmpty() && k > 0){
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
            k--;
        }
        while (!q.isEmpty()){
            res.add(q.poll());
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
