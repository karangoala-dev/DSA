package Algorithms.PrefixSum;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        //store the prefix sum % k as key and index as value
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            //now we need a prefix such that -> currSum - prefixSum = k * some_factor
            //i.e. (currSum - prefixSum) % k == 0
            //eg: if arr is [23,4,2,6,7] and k = 6 then ans will include [4,2], also if 23%6 is 5 then (23+4+2) is also 5
            int remainder = currSum % k;

            System.out.println(remainder + " " + map.get(remainder));

            if(map.containsKey(remainder) && i - map.get(remainder) >= 2){
                //if this remainder was observed earlier, find the index and check if >= 2
                return true;
            }

            //add the remainder and index to map
            //this if statement is required for an edge case, or else it works fine with just map.put without if
            //edge case is when arr = [5,0,0,0] and k = 3, here due to 0, each index has same remainder and for all 0 indices, map value gets updated and
            //so index >= 2 condition is not satisfied
            if(!map.containsKey(remainder)){
                map.put(remainder, i);
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
