package Revision;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: tasks){
            if(!freqMap.containsKey(c)){
                freqMap.put(c, 0);
            }
            freqMap.put(c, freqMap.get(c) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        //store frequency and time when it will be free in the queue
        Queue<int[]> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()){
            pq.add(entry.getValue());
        }

        int time = 0;
        while (!q.isEmpty() || !pq.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int maxFreq = pq.poll();
                if(maxFreq != 1){
                    //means highest frequency needs to be re-processed later after n time has elapsed
                    q.add(new int[]{maxFreq - 1, time + n});
                }
            }
            if(!q.isEmpty()){
                if(q.peek()[1] == time){
                    //after doing pq.poll, check if time is equal to front of queue's required elapsed time, then re-add to the pq
                    int[] curr = q.poll();
                    pq.add(curr[0]);
                }
            }
        }
        return time;
    }
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
    }
}
