package Algorithms.BinarySearch;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        if(r == 0){
            return 0;
        }
        if(r == 1){
            return Math.max(nums[l], nums[r]) == nums[l] ? 0 : 1;
        }
        while(l <= r){
            int mid = ((r - l) / 2) + l;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            if (mid != 0 && nums[mid] < nums[mid - 1] ) {
                //go left
                r = mid - 1;
            }
            else {
                //go right
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
