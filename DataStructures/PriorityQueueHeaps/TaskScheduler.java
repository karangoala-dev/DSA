package DataStructures.PriorityQueueHeaps;

import java.util.*;

public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            HashMap<Character, Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(char ch: tasks){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                pq.add(entry.getValue());
            }

            Queue<int[]> q = new LinkedList<>();
            int t = 0;
            while(pq.size() != 0 || q.size() != 0){
                t++;

                if(!pq.isEmpty()){
                    int highestTaskFreq = pq.poll();
                    if(highestTaskFreq - 1 != 0){
                        int[] current = new int[]{highestTaskFreq - 1, t + n};
                        q.add(current);
                    }
                }
                if(q.size() != 0){
                    if(q.peek()[1] == t){
                        int[] top = q.poll();
                        pq.add(top[0]);
                    }
                }
            }

            return t;
        }
    }

    public static void main(String[] args) {

    }
}
