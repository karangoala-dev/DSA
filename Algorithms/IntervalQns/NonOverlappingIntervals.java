package Algorithms.IntervalQns;

import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //min-heap according to 0th index
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] curr: intervals){
            pq.add(curr);
        }

        int[] prev = pq.poll();
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] < prev[1]){
                //just increment count, no need to set prev since this curr will be removed, humne maan liya
                res++;
                //one case is the larger interval(larger end time) is on top, since we arent sorting according to end time, we need to remove the one with larger end time
                //so, for that case we need to reset prev to the smaller duration wala interval
                if(prev[1] > curr[1]){
                    prev = curr;
                }
            }
            else{
                prev = curr;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
