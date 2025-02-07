package Algorithms.Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReachableIndex = 0;
        for(int i = 0; i < nums.length; i++){
            //Check if index is unreachable
            if(i > maxReachableIndex){
                return false;
            }
            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
