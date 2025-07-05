package Revision;

import java.util.*;

class Node {
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

public class CloneGraph {
    HashMap<Integer, Node> map;
    public void helper(Node node, HashSet<Integer> vis){
        if(vis.contains(node.val)){
            return;
        }

        vis.add(node.val);
        Node clone = map.containsKey(node.val) ? map.get(node.val) : new Node(node.val, new ArrayList<>());
        map.put(node.val, clone);
        List<Node> neis = node.neighbors;
        for(Node nei: neis){
            if(map.containsKey(nei.val)){
                clone.neighbors.add(map.get(nei.val));
            }
            else {
                //this nei is not seen before, so add to map, neighbours and recurse on this
                Node clonedNei = new Node(nei.val, new ArrayList<>());
                map.put(nei.val, clonedNei);
                clone.neighbors.add(map.get(nei.val));
                helper(nei, vis);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        map = new HashMap<>();
        helper(node, new HashSet<>());
        return map.get(node.val);
    }
    public static void main(String[] args) {

    }
}
