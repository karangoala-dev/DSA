package Algorithms.IntervalQns;

import java.util.PriorityQueue;

public class MeetingRooms2 {
    private static class Pair{
        int time;
        boolean isStart;
        Pair(int _t, boolean _f){
            this.time = _t;
            this.isStart = _f;
        }
    }
    public int minMeetingRooms(int[][] intervals){
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2)->o1.time-o2.time);
        for(int[] curr: intervals){
            pq.add(new Pair(curr[0], true));
            pq.add(new Pair(curr[1], false));
        }
        int res = Integer.MIN_VALUE;
        int curr = 0;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            curr = p.isStart ? curr + 1 : curr - 1;
            res = Math.max(res, curr);
        }
        return res;
    }
    public static void main(String[] args) {
        MeetingRooms2 obj = new MeetingRooms2();

        int[][] test1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] test2 = {{7, 10}, {2, 4}};
        int[][] test3 = {{1, 5}, {8, 9}, {8, 9}};
        int[][] test4 = {{0, 10}, {10, 20}};

        System.out.println(obj.minMeetingRooms(test1)); // Output: 2
        System.out.println(obj.minMeetingRooms(test2)); // Output: 1
        System.out.println(obj.minMeetingRooms(test3)); // Output: 2
        System.out.println(obj.minMeetingRooms(test4)); // Output: 1
    }
}
