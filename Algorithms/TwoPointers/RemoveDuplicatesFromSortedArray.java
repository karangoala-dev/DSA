package Algorithms.TwoPointers;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, currJ = nums[0];
        //Here, i will be the last element of the sorted and all-unique part of array, initially assume it as 0
        while(j < nums.length){
            while(j < nums.length && nums[j] == currJ){
                j++;
            }
            //Now we found a unique value in j-th position
            //so, swap with i+1, also store this in currJ
            if(j < nums.length && i < j){
                currJ = nums[j];
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                j++;
                i++;
            }
        }

        return i + 1;
    }
    public static void main(String[] args) {

    }
}
