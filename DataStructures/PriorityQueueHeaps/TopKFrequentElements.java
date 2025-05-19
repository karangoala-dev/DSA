package DataStructures.PriorityQueueHeaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> freqMap.get(o2) - freqMap.get(o1));
        for(int i = 0; i < nums.length; i++){
            //generate freq map
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            //insert to maxHeap
            maxHeap.add(entry.getKey());
        }

        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }

        return res;
    }
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] res = topKFrequentElements.topKFrequent(new int[]{1,2,1,1,2,3}, 2);
        Arrays.stream(res).forEach(i -> System.out.print(i + ","));
    }
}
