package Revision;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        //For odd length
        for(int i = 0; i < s.length(); i++){
            int p1 = i, p2 = i;
            //now keep expanding while in bounds and s[p1] == s[p2] considering i as center
            while(p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
                if(resLen < p2 - p1 + 1){
                    resLen = p2 - p1 + 1;
                    res = s.substring(p1, p2 + 1);
                }
                p1--;
                p2++;
            }
        }

        //For even length
        for(int i = 0; i < s.length() - 1; i++){
            int p1 = i, p2 = i + 1;
            //now keep expanding while in bounds and s[p1] == s[p2] considering i as center
            while(p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
                if(resLen < p2 - p1 + 1){
                    resLen = p2 - p1 + 1;
                    res = s.substring(p1, p2 + 1);
                }
                p1--;
                p2++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
    }
}
