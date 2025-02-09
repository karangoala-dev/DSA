package Algorithms.Greedy;
import java.util.*;
public class JobSequencing {
    public int getMax(int[] arr){
        int res = Integer.MIN_VALUE;
        for(int i: arr){
            res = Math.max(res, i);
        }
        return res;
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profitArr) {
        // code here..
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for(int i = 0; i < id.length; i++){
            int[] curr = new int[]{id[i], deadline[i], profitArr[i]};
            pq.add(curr);
        }
        int maxDeadline = getMax(deadline);

        int[] timeline = new int[maxDeadline + 1];
        Arrays.fill(timeline, -1);
        int count = 0, profit = 0;
        while(pq.size() != 0){
            int[] curr = pq.poll();
            if(timeline[curr[1]] == -1){
                timeline[curr[1]] = curr[0];
                count++;
                profit += curr[2];
            }
            else{
                int i = curr[1];
                while(i > 0){
                    if(timeline[i] == -1){
                        break;
                    }
                    i--;
                }
                if(i > 0){
                    count++;
                    profit += curr[2];
                    timeline[i] = curr[0];
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(profit);
        return res;
    }

    public static void main(String[] args) {

    }
}
