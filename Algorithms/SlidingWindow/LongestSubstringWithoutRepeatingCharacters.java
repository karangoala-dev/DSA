package Algorithms.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int l = 0, r = 0;
        while(r < s.length()){
            Character c = s.charAt(r);
            if(map.containsKey(c)){
                //contract window from left until we do not find the previous instance of the character
                while (l < r && s.charAt(l) != c){
                    Character outgoing = s.charAt(l);
                    map.put(outgoing, map.get(outgoing) - 1);
                    if(map.get(outgoing) == 0){
                        map.remove(outgoing);
                    }
                    l++;
                }
                //now if l != r, then we remove the l element again since this is the duplicate element
                if(l != r){
                    Character outgoing = s.charAt(l);
                    map.put(outgoing, map.get(outgoing) - 1);
                    if(map.get(outgoing) == 0){
                        map.remove(outgoing);
                    }
                    l++;
                }
            }
            else {
                int currLen = r - l + 1;
                res = Math.max(res, currLen);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            r++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    //See this efficient and simpler way
    public int lengthOfLongestSubstring_efficient(String s) {
        //here instead of frequency we store index of where we encountered this character
        HashMap<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int l = 0, r = 0;
        while(r < s.length()){
            Character c = s.charAt(r);
            if(map.containsKey(c) && map.get(c) >= l){
                //means the character has been seen before and it is inside the window width
                l = map.get(c) + 1;
            }
            else {
                // means so far all unique characters
                res = Math.max(res, r - l + 1);
            }
            map.put(c, r);
            r++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_efficient("pwwkew"));
    }
}
