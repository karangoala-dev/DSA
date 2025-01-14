package DataStructures.Strings;

import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(sMap.equals(pMap)){
            res.add(0);
        }
        int l = 0;
        for(int r = p.length(); r < s.length(); r++){
            sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
            if(sMap.get(s.charAt(l)) == 0){
                sMap.remove(s.charAt(l));
            }
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            l++;
            if(sMap.equals(pMap)){
                res.add(l);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
