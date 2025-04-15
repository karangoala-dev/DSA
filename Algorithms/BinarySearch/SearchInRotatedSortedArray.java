package Algorithms.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while(l <= h){
            int mid = (l + (h - l) / 2);
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                //target smaller than mid value
                if(nums[l] <= nums[mid]){
                    //means we are on left side sorted portion
                    if(target < nums[l]){
                        //go right
                        l = mid + 1;
                    }
                    else{
                        //go left
                        h = mid - 1;
                    }
                }
                else{
                    //means we are on right side of the sorted rotated portion
                    //here for a smaller value than mid, only one option is correct
                    //target must be on left
                    h = mid - 1;
                }
            }
            else{
                //target greater than mid value
                if(nums[l] <= nums[mid]){
                    //if we are on left side go right
                    l = mid + 1;
                }
                else{
                    //if we are on right side then
                    if(target > nums[h]){
                        //go left
                        h = mid - 1;
                    }
                    else{
                        //go right
                        l = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
