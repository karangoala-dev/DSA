package Algorithms.Greedy;

import java.util.*;

public class NMeetingsInOneRoom {
    public int maxMeetings(int start[], int end[]) {
        int res = 0, prevEnd = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int i = 0; i < start.length; i++){
            int[] curr = new int[]{start[i], end[i]};
            pq.add(curr);
        }
        while(pq.size() != 0){
            int[] curr = pq.poll();
            if(curr[0] > prevEnd){
                res++;
                prevEnd = curr[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
