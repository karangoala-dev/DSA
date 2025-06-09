package DataStructures.PriorityQueueHeaps;

import JavaBasics.InputBufferedReader;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    private static class Pair{
        int first;
        int second;
        Pair(int _f, int _s){
            this.first = _f;
            this.second = _s;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        //max heap, we store value at first and freq at second
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.second - o1.second);
        int[] res = new int[barcodes.length];
        int i = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: barcodes){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Pair previous = null;
        while (!pq.isEmpty() || previous != null){
            Pair curr = pq.poll();
            res[i] = curr.first;
            i++;
            curr.second -= 1;
            if(previous != null){
                pq.add(previous);
            }

            if(curr.second != 0){
                previous = curr;
            }
            else {
                previous = null;
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
