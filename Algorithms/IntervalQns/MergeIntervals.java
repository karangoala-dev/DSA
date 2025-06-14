package Algorithms.IntervalQns;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        for(int[] curr: intervals){
            pq.add(curr);
        }
        int prevEndsAt = -1;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] <= prevEndsAt){
                //means we gotta merge
                int end = Math.max(curr[1], res.get(res.size() - 1)[1]);
                res.get(res.size() - 1)[1] = end;
                prevEndsAt = end;
            }
            else {
                res.add(curr);
                prevEndsAt = curr[1];
            }
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {

    }
}
