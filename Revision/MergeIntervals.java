package Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[0]-o2[0]);
        for(int[] curr: intervals){
            pq.add(curr);
        }

        int[] prev = pq.poll();
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] <= prev[1]){
                //merge
                prev[1] = Math.max(curr[1], prev[1]);
            }
            else {
                //add prev to result and refresh prev value
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {

    }
}
