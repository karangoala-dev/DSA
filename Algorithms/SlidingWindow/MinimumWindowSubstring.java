package Algorithms.SlidingWindow;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.equals("")){
            return "";
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        //generate hashmap for t as it will stay constant throughout
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        //we want to expand our window from right and if we have all necessary characters in current window, shrink from left until we do no longer have all chars
        //then if we do not have all then we expand right side
        //This way we will be able to find minimum window width

        //variables have and need signify total characters we have in string 's' which match with 't' and need signifies total chars we need to satisfy respectively
        int have = 0, need = tMap.size();
        int l = 0, resLen = Integer.MAX_VALUE;
        int[] res = {-1,-1};

        for(int r = 0; r < s.length(); r++){
            Character c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            //we used equals method so that we can handle cases where large numbers are to be compared, since this is an Integer and not int
            if(tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))){
                //means we just satisfied a condition and we can now increase our 'have'
                have++;
            }

            //keep narrowing the window from left while condition is kept satisfied
            while(have == need){
                int currLen = r - l + 1;
                if(currLen < resLen){
                    //if window is smaller, consider for result
                    resLen = currLen;
                    res[0] = l;
                    res[1] = r;
                }
                Character outgoing = s.charAt(l);
                sMap.put(outgoing, sMap.get(outgoing) - 1);
                if(tMap.containsKey(outgoing) && sMap.get(outgoing) < tMap.get(outgoing)){
                    //means we removed a required character
                    have--;
                }
                l++;
            }
        }

        if(res[0] == -1 && res[1] == -1){
            return "";
        }

        return s.substring(res[0], res[1] + 1);
    }
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
