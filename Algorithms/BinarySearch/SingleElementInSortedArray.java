package Algorithms.BinarySearch;

public class SingleElementInSortedArray {
    public int singleNonDuplicate_O_n(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prev = nums[0];
        int flag = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev){
                flag--;
            }
            else {
                flag++;
                prev = nums[i];
                if(flag > 1){
                    return nums[i - 1];
                }
            }
        }
        if(flag > 0){
            //means last element occurs once
            return nums[nums.length - 1];
        }
        return -1;
    }
    //Optimised version, O(log n)
    public int singleNonDuplicate(int[] nums) {
        //always go to the side which is not equal to mid
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid  = l + ((r - l) / 2);
            //edge case handling
            if(mid == 0 || mid == nums.length - 1 || (nums[mid] != nums[mid - 1] && (nums[mid] != nums[mid + 1]))){
                return nums[mid];
            }

            //if even then must be equal to prev ind
            if((mid + 1) % 2 == 0){
                if(nums[mid - 1] == nums[mid]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            else {
                //else must be equal to next index
                if(nums[mid + 1] == nums[mid]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {

    }
}
