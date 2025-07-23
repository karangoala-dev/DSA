package Revision;

import CollectionsFramework.TreeSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 0;
        for(int num: set){
            if(!set.contains(num - 1)){
                int currLen = 1;
                int currNum = num;
                while(set.contains(currNum + 1)){
                    currLen++;
                    currNum++;
                }
                res = Math.max(res, currLen);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
