package Revision;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_Ap2 {
    //Time complexity : O(n log k)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //Here we store using a minHeap
        //such that we have the k largest elements only, if size exceed k, do a poll and remove current smallest
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        //One more thing to keep in mind is we can return ans in any order, so we can return directly in increasing order from heap
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
