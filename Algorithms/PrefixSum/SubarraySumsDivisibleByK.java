package Algorithms.PrefixSum;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        //remainder vs frequency of this remainder in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int remainder = currSum % k;
            //normalisation step since java can give -ve remainders
            //In Java, -1 % 3 = -1, not 2
            remainder = (remainder + k) % k;
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
