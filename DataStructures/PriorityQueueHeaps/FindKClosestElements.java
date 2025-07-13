package DataStructures.PriorityQueueHeaps;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i: arr){
            int diff = Math.abs(x - i);
            pq.add(new int[]{i, diff});
        }

        List<Integer> res = new ArrayList<>();
        while(k != 0){
            res.add(pq.poll()[0]);
            k--;
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {

    }
}
