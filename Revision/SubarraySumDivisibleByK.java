package Revision;

import java.util.HashMap;

public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int remainder = currSum % k;
            remainder = (remainder + k) % k; //normalisation step for java

            if(map.containsKey(remainder)){
                res += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
