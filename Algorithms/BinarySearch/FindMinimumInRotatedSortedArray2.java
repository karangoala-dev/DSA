package Algorithms.BinarySearch;

public class FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < res){
                res = nums[mid];
            }

            if(nums[mid] > nums[r]){
                //go right
                l = mid + 1;
            }
            else if(nums[mid] < nums[r]){
                //go left
                r = mid - 1;
            }
            else{
                //means mid and r are equal, so move r by one only
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
