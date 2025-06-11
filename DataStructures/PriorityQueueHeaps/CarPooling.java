package DataStructures.PriorityQueueHeaps;

import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        //min-heap to process each location in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int maxDist = Integer.MIN_VALUE;
        for(int[] t: trips){
            //for each row, add and subtract passengers based on pickup and drop
            pq.add(new int[]{t[1],-1 * t[0]});
            pq.add(new int[]{t[2],t[0]});
            maxDist = Math.max(maxDist, Math.max(t[1], t[2]));
        }
        int[] arr = new int[maxDist + 1];
        while(!pq.isEmpty()){
            //populate the arr for each distance milestone with + or minus, this is done to combine passenger movement for separate trips
            int[] curr = pq.poll();
            arr[curr[0]] += curr[1];
        }

        int cap = capacity;
        for(int i = 0; i < arr.length; i++){
            cap += arr[i];
            if(cap < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
