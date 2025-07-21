package Striver150;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //diff vs frequency
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
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{1,2,3}, 3));
    }
}
