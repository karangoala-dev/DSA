package DataStructures.Graphs;

import java.util.*;

public class DisjointSetUnionBySize {
    List<Integer> size;
    List<Integer> parent;
    DisjointSetUnionBySize(int n){
        this.size = new ArrayList<>(n + 1);
        this.parent = new ArrayList<>(n + 1);
        for(int i = 0; i < n + 1; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }

        int res = findParent(parent.get(node));
        parent.set(node, res);
        return res;
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        //Already connected
        if(ulp_v == ulp_u){
            return;
        }

        //Attach v to u if v smaller
        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        //Attach u to v if u is smaller
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        //if both equal then anything is fine
        else{
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }

    public static void main(String[] args) {
        DisjointSetUnionBySize ds = new DisjointSetUnionBySize(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        System.out.println(ds.findParent(3) == ds.findParent(7)); // false

        ds.unionBySize(3, 7);
        System.out.println(ds.findParent(3) == ds.findParent(7)); // true
    }
}
