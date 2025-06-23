package Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> topoSort = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                topoSort.add(i);
            }
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            List<Integer> neis = adj.get(curr);
            for(int nei: neis){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    topoSort.add(nei);
                    q.add(nei);
                }
            }
        }
        return topoSort.size() == numCourses ? true : false;
    }
    public static void main(String[] args) {

    }
}
