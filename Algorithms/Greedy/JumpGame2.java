package Algorithms.Greedy;

import java.util.Arrays;

public class JumpGame2 {
    public static int helper(int[] nums, int i, int jumps){
        if(i >= nums.length - 1){
            return jumps;
        }

        int possibleJumps = nums[i];
        int res = Integer.MAX_VALUE;
        for(int j = 1; j <= possibleJumps; j++){
            res = Math.min(helper(nums, i + j, jumps + 1), res);
        }
        return res;
    }

    //This recursive approach has exponential time complexity, so cant use this fren
    public static int jump_recursive(int[] nums) {
        return helper(nums, 0, 0);
    }


    public static void main(String[] args) {
        System.out.println(jump_recursive(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
