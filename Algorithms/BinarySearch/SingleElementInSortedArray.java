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
    public static void main(String[] args) {

    }
}
