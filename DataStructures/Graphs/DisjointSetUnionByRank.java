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
            parent.add(i);
            rank.add(0);
        }
    }

    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }
        //Path compression
        int res = findParent(parent.get(node));
        parent.set(node, res);
        return  res;
    }

    public void unionByRank(int u, int v){
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        //If already connected then return
        if(ultimateParentU == ultimateParentV){
            return;
        }

        //If rank(u) < rank(v) then set u's parent as v(larger rank value means higher up)
        if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
            parent.set(ultimateParentU, ultimateParentV);
        }
        //If rank(u) > rank(v) then set parent of v as u.
        else if(rank.get(ultimateParentU) > rank.get(ultimateParentV)){
            parent.set(ultimateParentV, ultimateParentU);
        }
        //If same rank then set any value as parent of another, I set v as parent of u and also increment rank for v
        else{
            parent.set(ultimateParentU, ultimateParentV);
            rank.set(ultimateParentV, rank.get(ultimateParentU) + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSetUnionByRank ds = new DisjointSetUnionByRank(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        System.out.println(ds.findParent(3) == ds.findParent(7)); // false

        ds.unionByRank(3, 7);
        System.out.println(ds.findParent(3) == ds.findParent(7)); // true
    }
}
