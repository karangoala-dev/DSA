package Algorithms.SlidingWindow;

public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0;
        long currSum = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            currSum += nums[r];
            double len = r - l + 1;
            double threshold = k / len;

            while(l <= r && (double)currSum >= threshold){
                //decrease len by moving l
                currSum -= nums[l];
                l++;
                len = r - l + 1;
                threshold = k / len;
            }

            res += (r - l + 1);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
