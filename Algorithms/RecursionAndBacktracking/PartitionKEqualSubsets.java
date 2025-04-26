package Algorithms.RecursionAndBacktracking;

public class PartitionKEqualSubsets {
    public boolean helper(int[] nums, int ind, int[] subsetSums, int target){
        if(ind == nums.length){
            for(int sum: subsetSums){
                if(sum != target){
                    //if any subset sum != target, then return false
                    return false;
                }
            }
            return true;
        }

        int k = subsetSums.length;
        for(int i = 0; i < k; i++){
            //for each subset, we check if current index is a fit or not
            if(subsetSums[i] + nums[ind] <= target){
                //then try recursion with this
                subsetSums[i] += nums[ind];
                if(helper(nums, ind + 1, subsetSums, target) == true){
                    //if this config returns true, return true.
                    return true;
                }
                //else backtrack
                subsetSums[i] -= nums[ind];
            }
        }
        return false;
    }
    //TC(O(k^n)), gives TLE
    public boolean canPartitionKSubsets_O_k_pow_n(int[] nums, int k) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        int[] subsetSums = new int[k];
        return helper(nums, 0, subsetSums, target);
    }
    public static void main(String[] args) {
        PartitionKEqualSubsets solution = new PartitionKEqualSubsets();
        System.out.println(solution.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }
}
