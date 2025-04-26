package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PartitionKEqualSubsets {
    //Un-optimised approach
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

        //sort nums in descending order to quickly remove larger elements
        Arrays.sort(nums);
        for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return helper(nums, 0, subsetSums, target);
    }

    //Optimised approach O(k * 2^n), even this gives TLE
    public boolean backtrack(int[] nums, int k, int ind, int subsetSum, int[] visited, int target){
        if(k == 0){
            //means, all subsets generated
            return true;
        }
        if(subsetSum == target){
            //now check for other subsets after decrementing k by one
            return backtrack(nums, k - 1, 0, 0, visited, target);
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || subsetSum + nums[i] > target){
                continue;
            }

            visited[i] = 1;
            if(backtrack(nums, k, i + 1, subsetSum + nums[i], visited, target)){
                return true;
            }
            visited[i] = 0;
        }
        return false;
    }
    public boolean canPartitionKSubsets_TLE(int[] nums, int k) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        int[] visited = new int[nums.length];
        return backtrack(nums, k, 0, 0, visited, target);
    }

    //Working approach, not TLE for this
    //5 optimisations on above approach
    //1-> sort nums in reverse order(imp optimisation)
    //2-> start from ind and not 0, as we have already visited 0 -> ind - 1 in previous call(most important optimization)
    //3-> use a boolean array instead of int[] as it is faster slightly
    //4-> once one way fails at the start of a subset(if subsetSum == 0 after backtracking, then no need to go further), we don’t try the rest — we break.(dk why it works)
    //5-> skip duplicate values in the sorted array nums to avoid redundant work.(dk why it works)
    public boolean backtrack(int[] nums, int k, int ind, int subsetSum, boolean[] visited, int target){
        if(k == 0){
            //means, all subsets generated
            return true;
        }
        if(subsetSum == target){
            //now check for other subsets after decrementing k by one
            return backtrack(nums, k - 1, 0, 0, visited, target);
        }

        //2-> start from ind and not 0, as we have already visited 0 -> ind - 1 in previous call
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || subsetSum + nums[i] > target){
                continue;
            }

            visited[i] = true;
            if(backtrack(nums, k, i + 1, subsetSum + nums[i], visited, target)){
                return true;
            }
            visited[i] = false;
            //4-> once one way fails at the start of a subset(if subsetSum == 0 after backtracking, then no need to go further), we don’t try the rest — we break.
            if (subsetSum == 0) {
                break;
            }
            //5-> skip duplicate values in the sorted array nums to avoid redundant work.
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % k != 0){
            return false;
        }

        //1-> sort nums in descending order to quickly remove larger elements
        Arrays.sort(nums);
        for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int target = sum / k;

        //3-> use a boolean array instead of int[] as it is faster slightly
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, k, 0, 0, visited, target);
    }

    public static void main(String[] args) {
        PartitionKEqualSubsets solution = new PartitionKEqualSubsets();
        System.out.println(solution.canPartitionKSubsets_O_k_pow_n(new int[]{4,3,2,3,5,2,1}, 4));
    }
}
