package Revision;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < res){
                //select current ans
                res = nums[mid];
            }

            //now check for better value
            if(nums[mid] > nums[r]){
                //we are on greater part of rotated arr, so go right
                l = mid + 1;
            }
            else{
                //we are on smaller part of rotated arr, so go left
                r = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
