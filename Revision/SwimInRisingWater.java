package Revision;

import Revision.utils.Trio;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(n == 1 && m == 1){
            return grid[n - 1][m - 1];
        }
        PriorityQueue<Trio> pq = new PriorityQueue<>((o1, o2) -> o1.third - o2.third);
        int[][] height = new int[n][m];
        for(int[] curr: height){
            Arrays.fill(curr, Integer.MAX_VALUE);
        }
        pq.add(new Trio(0, 0, grid[0][0]));

        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};
        while (!pq.isEmpty()){
            Trio curr = pq.poll();
            if(curr.first == n - 1 && curr.second == m - 1){
                return curr.third;
            }
            for(int i = 0; i < 4; i++){
                int nR = rows[i] + curr.first;
                int nC = cols[i] + curr.second;
                if(nR >= 0 && nC >= 0 && nR < n && nC < m && height[nR][nC] > Math.max(curr.third, grid[nR][nC])){
                    //if it is in bounds and we found a height for nR and nC which is better than what we have rn, explore further
                    pq.add(new Trio(nR, nC, Math.max(curr.third, grid[nR][nC])));
                    height[nR][nC] = Math.max(curr.third, grid[nR][nC]);
                }
            }
        }

        return height[n - 1][m - 1];
    }
    public static void main(String[] args) {

    }
}
