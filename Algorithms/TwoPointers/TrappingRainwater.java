package Algorithms.TwoPointers;

public class TrappingRainwater {
    public int trap_On_memory(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = height[n - 1];

        //Generate prefix max and suffix max arrays
        for(int i = 1; i < n; i++){
            int lIndex = i, rIndex = n - 1 - i;
            prefixMax[lIndex] = Math.max(prefixMax[lIndex - 1], height[lIndex]);
            suffixMax[rIndex] = Math.max(suffixMax[rIndex + 1], height[rIndex]);
        }

        //iterate and compute volume for each
        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.min(prefixMax[i], suffixMax[i]) - height[i];
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
