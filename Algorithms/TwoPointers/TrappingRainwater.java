package Algorithms.TwoPointers;

public class TrappingRainwater {
    public int trap_On_memory(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        //generate l and r arrays(max so far from left and right sides)
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i - 1], height[i]);
            right[n - 1 - i] = Math.max(right[n - i], height[n - 1 - i]);
        }
        //now compute result
        int res = 0;
        for(int i = 0; i < n; i++){
            int currVolume = Math.min(left[i], right[i]) - height[i];
            if(currVolume > 0){
                res += currVolume;
            }
        }
        return res;
    }
    public int trap_Ok_memory(int[] height) {
        int n = height.length;
        int leftMax = height[0], rightMax = height[n - 1];
        int l = 0, r = n - 1, res = 0;
        //l < r because we cant trap water at single bar
        while(l < r){
            if(leftMax < rightMax){
                //move the smaller pointer
                l++;
                //update max value of that side
                leftMax = Math.max(leftMax, height[l]);
                //We move to a new index, update the max seen till now on that side, and compute trapped water at that index.
                res += leftMax - height[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
