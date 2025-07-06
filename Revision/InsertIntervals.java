package Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[0], o2[0]));
        pq.add(newInterval);
        for(int[] curr: intervals){
            pq.add(curr);
        }

        List<int[]> res = new ArrayList<>();
        int prevEndsAt = -1;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] <= prevEndsAt){
                //we gotta merge
                res.get(res.size() - 1)[1] = Math.max(prevEndsAt, curr[1]);
            }
            else {
                res.add(curr);
            }
            prevEndsAt = Math.max(prevEndsAt, curr[1]);
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {

    }
}
