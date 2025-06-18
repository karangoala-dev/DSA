package Algorithms.IntervalQns;

import java.util.PriorityQueue;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        for(int[] curr: intervals){
            pq.add(curr);
        }

        int count = 0;
        int[] prev = pq.poll();
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(prev[1] >= curr[1]){
                count++;
            }
            prev = curr;
        }

        return intervals.length - count;
    }
    public static void main(String[] args) {

    }
}
