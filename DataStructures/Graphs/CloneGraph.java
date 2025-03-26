package DataStructures.Graphs;

import java.util.*;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public void dfs(Node node, HashMap<Node, Node> map){
        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);
        List<Node> neis = node.neighbors;
        for(Node nei: neis){
            if(map.containsKey(nei)){
                clonedNode.neighbors.add(map.get(nei));
            }
            else{
                dfs(nei, map);
                clonedNode.neighbors.add(map.get(nei));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    public static void main(String[] args) {

    }
}
