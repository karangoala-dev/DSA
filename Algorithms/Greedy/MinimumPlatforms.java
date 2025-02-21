package Algorithms.Greedy;

import java.util.*;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int[][] trains = new int[n][2];

        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }

        Arrays.sort(trains, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int res = 1;
        for(int i = 0; i < trains.length; i++){
            if(pq.size() == 0 || pq.peek()[1] >= trains[i][0]){
                pq.add(new int[] {trains[i][0], trains[i][1]});

            }
            else{
                pq.poll();
                pq.add(new int[] {trains[i][0], trains[i][1]});
            }
            res = Math.max(res, pq.size());
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
