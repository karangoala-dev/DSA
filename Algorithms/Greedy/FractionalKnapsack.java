package Algorithms.Greedy;

import java.util.*;

public class FractionalKnapsack {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2[0] / (double) o2[1], o1[0] / (double) o1[1]));
        for(int i = 0; i < val.size(); i++){
            pq.add(new int[] {val.get(i), wt.get(i)});
        }
        double res = 0;
        boolean isFrac = false;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(capacity >= curr[1]){
                res += curr[0];
                capacity -= curr[1];
            }
            else{
                res += (curr[0] / (double) curr[1]) * capacity;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
