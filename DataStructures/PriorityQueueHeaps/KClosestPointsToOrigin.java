package DataStructures.PriorityQueueHeaps;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public double getDistance(int[] point){
        return Math.pow(Math.pow(point[0], 2) + Math.pow(point[1], 2), 0.5);
    }
    public int[][] kClosest(int[][] points, int k) {
        //min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(getDistance(o1), getDistance(o2)));
        for(int[] point: points){
            pq.add(point);
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
