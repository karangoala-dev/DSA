package Algorithms.IntervalQns;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        //add all intervals to pq, along with new one
        pq.add(newInterval);
        for(int[] curr: intervals){
            pq.add(curr);
        }
        int prevEndsAt = -1;

        //now poll one by one and see if it merges with the previous one
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] <= prevEndsAt){
                //means we need to merge it, find the end as max of 2
                //Note: here we wont merge only the new interval, since new interval might result in more than one interval getting merged
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
