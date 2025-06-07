package Revision;

import java.util.*;

public class ReorganizeString {
    private static class Pair{
        char c;
        int v;
        Pair(char _c, int _v){
            this.c = _c;
            this.v = _v;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        if(pq.peek().v > (s.length() + 1)/ 2){
            return "";
        }

        Pair previous = null;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            sb.append(curr.c);
            curr.v -= 1;

            if(previous != null){
                pq.add(previous);
            }

            if(curr.v > 0){
                previous = curr;
            }
            else {
                previous = null;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("kkkkzrkatkwpkkkktrq"));
    }
}
