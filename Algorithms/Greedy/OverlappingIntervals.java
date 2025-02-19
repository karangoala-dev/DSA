package Algorithms.Greedy;

import java.util.*;

public class OverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            pq.add(curr);
        }
        int prevEnd = pq.peek()[0];
        while(pq.size() != 0){
            int[] curr = pq.poll();
            if(curr[0] < prevEnd){
                res++;
            }
            else{
                prevEnd = curr[1];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
