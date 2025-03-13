package DataStructures.Graphs;

import java.util.*;

public class CourseSchedule2 {
    //Here a cyclic graph is handled too
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int[] curr = prerequisites[i];
            indegree[curr[0]]++;
            adj.get(curr[1]).add(curr[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int i = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> neigh = adj.get(curr);
            for(int num: neigh){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
            i++;
            res.add(curr);
        }
        //This line ensures that 0 size array is returned if cycle exists
        //If a cycle exists in a Directed Acyclic Graph (DAG) problem, at some point, no new node will have an in-degree of 0.
        //This means no of processed nodes != numCourses
        if(i != numCourses){
            return new int[0];
        }

        return res.stream().mapToInt(I -> (int)I).toArray();
    }

    public static void main(String[] args) {

    }
}
