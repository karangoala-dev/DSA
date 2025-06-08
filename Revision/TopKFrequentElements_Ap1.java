package Revision;

import java.util.*;

public class TopKFrequentElements_Ap1 {
    //Approach O(n log n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //max heap to store according to frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getKey());
        }
        int[] res = new int[k];
        int i = 0;
        while(i != k){
            res[i] = pq.poll();
            i++;
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
