package Algorithms.Greedy;

import java.util.*;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int prevEnd = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(newInterval);
        for(int[] curr: intervals){
            pq.add(curr);
        }
        while(pq.size() != 0){
            int[] curr = pq.poll();
            if(curr[0] <= prevEnd){
                list.get(list.size() - 1)[1] = Math.max(curr[1], list.get(list.size() - 1)[1]);
                prevEnd = list.get(list.size() - 1)[1];
            }
            else{
                list.add(curr);
                prevEnd = curr[1];
            }
        }
        return list.toArray(new int[0][]);
    }
    public static void main(String[] args) {

    }
}
