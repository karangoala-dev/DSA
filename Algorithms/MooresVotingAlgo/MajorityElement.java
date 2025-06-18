package Algorithms.MooresVotingAlgo;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                //reset
                element = nums[i];
                count = 1;
            }
            else if(count != 0 && nums[i] != element){
                //decrease count
                count--;
            }
            else{
                //increase count
                count++;
            }
        }
        //at end, we have the majority element
        return element;
    }
    public static void main(String[] args) {

    }
}
