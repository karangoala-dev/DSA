package DataStructures.PriorityQueueHeaps;

import java.util.*;

public class ReorganizeStrings {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        char[] chArr = s.toCharArray();
        for(char ch: chArr){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(entry);
        }

        if(pq.peek().getValue() > (s.length() + 1) / 2){
            return "";
        }

        Map.Entry<Character, Integer> previous = null;
        while(!pq.isEmpty() || previous != null){
            Map.Entry<Character, Integer> current = pq.poll();
            res.append(current.getKey());
            if(previous != null){
                pq.add(previous);
                previous = null;
            }

            if(current.getValue() > 1){
                current.setValue(current.getValue() - 1);
            }
            else{
                current = null;
            }
            previous = current;
        }

        return res.toString();
    }
    public static void main(String[] args) {

    }
}
