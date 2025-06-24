package Revision;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else {
                if(st.isEmpty())
                    return false;
                if((c == ')' && st.peek() == '(') || (c == '}' && st.peek() == '{') || (c == ']' && st.peek() == '[')){
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.size() == 0 ? true : false;
    }
    public static void main(String[] args) {

    }
}
