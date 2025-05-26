package Algorithms.SlidingWindow;

public class SubarrayProductLessThanK {
    //Most efficient
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

    public int numSubarrayProductLessThanK_fails(int[] nums, int k) {
        int n = nums.length;
        long[] prefixProduct = new long[n + 1];
        prefixProduct[0] = 1L;
        long currProduct = 1L;
        int res = 0;
        for(int r = 0; r < n; r++){
            currProduct *= nums[r];
            prefixProduct[r + 1] = currProduct;

            //get l index, such that all inclusive element between l and r 's product is strictly less than k
            int l = 0;
            while(l <= r && prefixProduct[r + 1] / prefixProduct[l] >= k){
                l++;
            }

            res += (r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK_fails(new int[]{10,5,2,6}, 100));
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK_fails(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}
