package Algorithms.MooresVotingAlgo;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    //we can have at most 2 elements whose frequency is more than (n/3 + 1).
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int element1 = Integer.MAX_VALUE, element2 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(count1 == 0 && nums[i] != element2){
                count1 = 1;
                element1 = nums[i];
            }
            else if (count2 == 0 && nums[i] != element1) {
                count2 = 1;
                element2 = nums[i];
            }
            else if (nums[i] == element1) {
                count1++;
            }
            else if (nums[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        //reset the values
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == element1){
                count1++;
            }
            else if (nums[i] == element2) {
                count2++;
            }
        }

        int min = (n / 3) + 1;
        List<Integer> res = new ArrayList<>();
        if(count1 >= min){
            res.add(element1);
        }
        if(count2 >= min){
            res.add(element2);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
