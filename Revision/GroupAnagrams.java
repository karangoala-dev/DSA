package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        System.out.println(map);
        List<List<String>> res = new ArrayList<>();
        for (List<String> list: map.values()){
            res.add(list);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
