package DataStructures.PriorityQueueHeaps;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(entry);
        }

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curr = pq.poll();
            int count = curr.getValue();
            while(count != 0){
                sb.append(curr.getKey());
                count--;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
