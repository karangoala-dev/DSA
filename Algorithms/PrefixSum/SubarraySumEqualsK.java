package Algorithms.PrefixSum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    //TC = O(n + n2) = O(n2)
    public int subarraySum_inefficient(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int res = 0;
        //sum[l,r] = prefix[r + 1] - prefix[l]
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(prefix[j + 1] - prefix[i] == k){
                    res++;
                }
            }
        }

        return res;
    }

    //Approach#2 TC : O(N)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //store prefix sum and its frequency in a map
        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();
        //this 0 prefix is for cases where l = 0
        prefixFrequency.put(0, 1);
        int res = 0;
        int currSum = 0;

        for(int i = 0; i < n; i++){
            //now, we need some prefix like "currSum - prefix = k" | i.e we need to check in map of we have a prefix = currSum - k
            currSum += nums[i];
            res += prefixFrequency.getOrDefault(currSum - k, 0);
            prefixFrequency.put(currSum, prefixFrequency.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
