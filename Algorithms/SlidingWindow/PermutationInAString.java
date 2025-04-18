package Algorithms.SlidingWindow;

public class PermutationInAString {
    int[] s1Map = new int[26];
    int[] s2Map = new int[26];

    //This fn compares s1Map and s2Map and returns true if all characters match between the 2 maps
    public boolean allCharsMatch(){
        for(int i = 0; i < 26; i++){
            if(s1Map[i] != s2Map[i]){
                return false;
            }
        }
        return true;
    }

    //TC : O(26 * n)
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        //generate map for s1
        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
        }
        //generate map for intial window
        for(int i = 0; i < s1.length(); i++){
            s2Map[s2.charAt(i) - 'a']++;
        }
        //left and right pointers for window
        int l = 0, r = s1.length() - 1;
        while(r < s2.length()){
            if(allCharsMatch()){
                return true;
            }
            s2Map[s2.charAt(l) - 'a']--;
            l++;
            r++;
            if(r < s2.length()){
                s2Map[s2.charAt(r) - 'a']++;
            }
        }
        return false;
    }


    //small optimisation on above approach
    //TC O(n)

    public boolean checkInclusion_optimised(String s1, String s2) {
        int[] mapS1 = new int[26];
        int[] mapS2 = new int[26];
        //this variable keeps track of no of matches
        int matches = 0;

        if(s1.length() > s2.length()){
            return false;
        }
        //generate map for s1
        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
        }
        //generate map for intial window
        for(int i = 0; i < s1.length(); i++){
            s2Map[s2.charAt(i) - 'a']++;
        }

        //now count no of matches initially
        for(int i = 0; i < 26; i++){
            if(mapS1[i] == mapS2[i]){
                matches++;
            }
        }

        //r = right index
        for(int r = s1.length() - 1; r < s2.length(); r++){
            //left index of the window
            int l = r - s1.length();
        }
    }

    public static void main(String[] args) {

    }
}
