package DataStructures.Strings;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int resLen = 0;
        String res = "";
        for(int c = 0; c < s.length(); c++){
            int l, r;
            l = c;
            r = c;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > resLen){
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = c;
            r = c + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > resLen){
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
