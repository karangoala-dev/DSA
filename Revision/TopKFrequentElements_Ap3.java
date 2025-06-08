package Revision;

import java.util.*;

public class TopKFrequentElements_Ap3 {
    //Time complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //Here we store the element using index as frequency in an array, since max frequeuncy will be n, we use a 2D list of size n+1
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);
        for(int i = 0; i <= nums.length; i++){
            freq.add(new ArrayList<>());
        }
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int ind = 0;
        //now start from end of freq array to get max frequency
        for(int i = freq.size() - 1; i >= 0; i--){
            if(ind >= k){
                break;
            }
            if(freq.get(i).size() != 0){
                int j = 0;
                while(ind < k && j < freq.get(i).size()){
                    res[ind] = freq.get(i).get(j);
                    j++;
                    ind++;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
