package Algorithms.DynamicProgramming;

import java.util.*;

public class DungeonGame {
    int[][] dp;
    //This fn returns minimum hp needed to enter that cell
    public int helper(int[][] dungeon, int r, int c){
        int n = dungeon.length, m = dungeon[0].length;
        if(r >= n || c >= m){
            return 100001;
        }
        if(r == n - 1 && c == m - 1){
            //if cell val is +ve/0 return 1 and if -ve, return val such that hp is 1.
            return dungeon[r][c] >= 0 ? 1 : -dungeon[r][c] + 1;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        //downward path result - min hp needed to enter next cell down
        int res1 = helper(dungeon, r + 1, c);
        //rightside path result - min hp needed to enter next cell right
        int res2 = helper(dungeon, r, c + 1);

        //We want to have minimum hp needed to reach destination, so get that min hp
        int minHpNext = Math.min(res1, res2);

        //Hp needed for current cell
        //1. if current cell is +ve then we need a lower hp, so minHpNext - dungeon[r][c];
        //2. if current cell is -ve we need a higher hp
        int hpNeededForCurrentCell = minHpNext - dungeon[r][c];

        // 3. If we gain too much HP (e.g., dungeon[r][c] > minHpNext), hpNeeded might go ≤ 0
        //    In that case, we still need at least 1 HP to survive → so we do Math.max(1, ...)
        return dp[r][c] = Math.max(1, hpNeededForCurrentCell);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        dp = new int[n][m];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(dungeon, 0, 0);
    }
    public static void main(String[] args) {

    }
}
