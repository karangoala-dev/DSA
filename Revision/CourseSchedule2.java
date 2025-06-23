package Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] topoSort = new int[numCourses];
        int t = 0;
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                topoSort[t] = i;
                count++;
                t++;
            }
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            List<Integer> neis = adj.get(curr);
            for(int nei: neis){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    topoSort[t] = nei;
                    q.add(nei);
                    count++;
                    t++;
                }
            }
        }
        if(count != numCourses){
            return new int[0];
        }
        return topoSort;
    }
    public static void main(String[] args) {

    }
}
