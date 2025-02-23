package Algorithms.Greedy;

public class ValidParenthesesString {
    public boolean checkValidString(String s) {
        int minRange = 0, maxRange = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '*'){
                minRange -= 1;
                maxRange += 1;
            }
            else if (c == '('){
                minRange += 1;
                maxRange += 1;
            }
            else{

                minRange -= 1;
                maxRange -= 1;
            }

            if(minRange < 0){
                minRange = 0;
            }

            if(maxRange < 0){
                return false;
            }
        }
        System.out.println(minRange + "," + maxRange);
        if(minRange == 0 && maxRange >= 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
