package Revision;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        while (m < nums.length){
            if(nums[m] == 0){
                int temp = nums[l];
                nums[l] = nums[m];
                nums[m] = temp;
                m++;
                l++;
            }
            else if(nums[m] == 1) {
                m++;
            }
            else {
                int temp = nums[r];
                nums[r] = nums[m];
                nums[m] = temp;
                m++;
                r--;
            }
        }
    }
    public static void main(String[] args) {

    }
}
