package Algorithms.PrefixSum;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int currProduct = 1;
        int l = 0;
        int res = 0;
        for(int r = 0; r < n; r++){
            currProduct *= nums[r];
            //get l index, such that all inclusive element between l and r 's product is strictly less than k
            while(l <= r && currProduct >= k){
                currProduct = currProduct / nums[l];
                l++;
            }

            res += (r - l + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1,1,1}, 1));
    }
}
