package Revision;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int diff = currSum - k;
            if(map.containsKey(diff)){
                res += map.get(diff);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
