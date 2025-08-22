package Algorithms.TwoPointers;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] != val){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
    public static void main(String[] args) {

    }
}
