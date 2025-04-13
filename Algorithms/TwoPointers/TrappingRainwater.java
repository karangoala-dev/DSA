package Algorithms.TwoPointers;

public class TrappingRainwater {
    public int trap(int[] height) {
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
    public static void main(String[] args) {

    }
}
