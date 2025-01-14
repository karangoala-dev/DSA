package DataStructures.Strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(map.containsKey(sortedString)){
                map.get(sortedString).add(str);
            }
            else{
                List<String> list = new ArrayList();
                list.add(str);
                map.put(sortedString, list);
            }
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
