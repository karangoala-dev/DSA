package Revision;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > nums[r]){
                //we are on greater side of rotation and l->mid is sorted
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                //we are on smaller side of rotation and mid->r is sorted
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
