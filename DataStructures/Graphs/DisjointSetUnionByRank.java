package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnionByRank {
    List<Integer> parent;
    List<Integer> rank;
    DisjointSetUnionByRank(int n){
        this.parent = new ArrayList<>(n + 1);
        this.rank = new ArrayList<>(n + 1);
        for(int i = 0; i <= n + 1; i++){
            //Initially a node is a parent of itself
            //And rank is 0 for all
            parent.set(i, i);
            rank.set(i, 0);
        }
    }

    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }
        //Path compression
        return parent.set(node, findParent(parent.get(node)));
    }

    public void unionByRank(int u, int v){
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
    }
}
