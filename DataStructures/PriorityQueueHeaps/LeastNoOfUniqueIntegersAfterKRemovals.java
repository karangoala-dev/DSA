package DataStructures.PriorityQueueHeaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNoOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        //min-heap of frequencies since we need to remove the least frequent ones
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            pq.add(entry.getValue());
        }

        while (!pq.isEmpty() && k >= pq.peek()){
            k -= pq.poll();
        }
        return pq.size();
    }
    public static void main(String[] args) {

    }
}
