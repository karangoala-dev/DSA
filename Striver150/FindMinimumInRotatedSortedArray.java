package Striver150;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r){
            int mid = (l + ((r - l) / 2));
            res = Math.min(nums[mid], res);

            if(nums[r] < nums[mid]){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
