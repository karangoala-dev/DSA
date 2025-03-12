package DataStructures.Graphs;

import java.util.*;

public class KahnAlgoTopologicalSortBFS {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            ArrayList<Integer> curr = adj.get(i);
            for(int num: curr){
                indegree[num]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> neighbours = adj.get(curr);
            for(int num: neighbours){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
            res.add(curr);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
