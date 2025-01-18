package Algorithms.TwoPointers;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //ignore current index if previous value was same as current
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            int threeSum;
            while(l < r){
                threeSum = nums[i] + nums[l] + nums[r];
                if(threeSum > 0){
                    r--;
                }
                else if(threeSum < 0){
                    l++;
                }
                else{
                    List<Integer> current = List.of(nums[i], nums[l], nums[r]);
                    res.add(current);
                    l++;
                    while(nums[l] == nums[l - 1] && l < r){
                        l++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
