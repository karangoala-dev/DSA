package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class PaintHouse {
    static Random rand = new Random();

    static int[][] dp;
    public static int helper(int[][] cost, int i, int prevColor){
        if(i >= cost.length){
            return 0;
        }

        if(prevColor != -1){
            if(dp[i][prevColor] != -1){
                return dp[i][prevColor];
            }
        }

        int res = Integer.MAX_VALUE;
        for(int color = 0; color < 3; color++){
            if(color == prevColor)
                continue;

            int curr = cost[i][color] + helper(cost, i + 1, color);
            res = Math.min(res, curr);
        }

        if(prevColor != -1){
            dp[i][prevColor] = res;
        }
        return res;
    }
    public static int paintHouse(int[][] cost){
        dp = new int[cost.length][3];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(cost, 0, -1);
    }
    public static void main(String[] args) {
        int n = 20;

        int[][] cost = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                cost[i][j] = rand.nextInt(100) + 1;
            }
        }

        long start = System.nanoTime();
        int res1 = paintHouse(cost);
        long end = System.nanoTime();
        System.out.println("Recursive Result: " + res1 + " Time: " + (end - start)/1_000_000.0 + " ms");

    }
}
