package DataStructures.Graphs;

import java.util.*;

public class CourseSchedule1 {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] curr: prerequisites){
            adj.get(curr[1]).add(curr[0]);
            indegree[curr[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> neigh = adj.get(curr);
            for(int i: neigh){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            res.add(curr);
        }
        return res.size() == n ? true : false;
    }
    public static void main(String[] args) {

    }
}
