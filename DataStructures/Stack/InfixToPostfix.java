package DataStructures.Stack;

import java.util.Stack;

public class InfixToPostfix {
    public static int priority(Character c){
        if(c == '^')
            //highest priority
            return 3;
        if(c == '+' || c == '-')
            return 2;
        if(c == '*' || c == '/')
            return 1;
        else
            return -1;
    }

    public static String infixToPostfix(String eq){
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i = 0; i < eq.length(); i++){
            Character c = eq.charAt(i);

            if((c >= 'a' && c <= 'z') || (c >= 'A' || c <= 'Z')){
                //if character, simply add to postfix expression
                postfix.append(c);
            }
            else if(c == '('){
                //if opening bracket, push it to stack
                st.push(c);
            }
            else if(c == ')'){
                //if closing bracket, pop and append to postfix until empty or opening bracket is reached
                while(!st.isEmpty() && st.peek() != '('){
                    postfix.append(st.pop());
                }
                //pop the opening branch
                st.pop();
            }
            else {
                //we reach here means it is an operator

            }
        }

        return postfix.toString();
    }

    public static void main(String[] args) {

    }
}
