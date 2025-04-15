package Algorithms.BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {

    //this array returns the sub-array count for a number of count(count = 1 unit of each element in the array)
    public int countSubarrays(int[] nums, int count){
        //initially we have only one sub-array
        int res = 1;
        int currCount = 0;
        for(int i = 0; i < nums.length; i++){
            //if it is feasible to add the index value to currentCount, then add it
            if(currCount + nums[i] <= count){
                currCount += nums[i];
            }
            //else, increase result count and reset the currCount to current index value
            else{
                res++;
                currCount = nums[i];
            }
        }
        return res;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        //since no sub-array can be empty
        if(k > n){
            return -1;
        }

        //low = max element in the array
        int l = Arrays.stream(nums).max().orElse(-1);
        //high = sum of all elements
        int h = Arrays.stream(nums).sum();

        while(l <= h){
            int mid = (l + (h - l) / 2);
            int subArrays = countSubarrays(nums, mid);

            //if no of subArrays is larger than k then go right to increase count and hence lower subArray count
            if(subArrays > k){
                l = mid + 1;
            }
            else {
                //else the count must be lowered to increase subArray count
                h = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        solution.splitArray(new int[] {7,2,5,10,8}, 1);
    }
}
