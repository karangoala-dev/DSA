package DataStructures.Stack;

import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++){
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0){
                k--;
                st.pop();
            }
            st.push(num.charAt(i));
        }
        if(k != 0){
            //remove k digits from end
            while(k > 0){
                st.pop();
                k--;
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        //remove preceding zeros, go till second last so that one zero is sent if needed
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
