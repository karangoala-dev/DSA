package DataStructures.Stack;

import java.util.Stack;

public class InfixToPrefix {
    public static int priority(Character c){
        if(c == '^')
            //highest priority
            return 3;
        if(c == '*' || c == '/')
            return 2;
        if(c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    //TC: O(2N), since one loop and each element can be inside stack only once, so one pop, so linear, O(N)
    //SC: O(2N), stack space and ans space
    public static String infixToPostfix(String eq){
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i = 0; i < eq.length(); i++){
            Character c = eq.charAt(i);

            //if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            if(Character.isLetterOrDigit(c)){
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
                //This bit is slightly different that what we did for infix to postfix
                if(c == '^'){
                    //basically we cant let two ^ be in the stack at same time
                    while (!st.isEmpty() && priority(c) <= priority(st.peek())){
                        postfix.append(st.pop());
                    }
                }
                else {
                    //if not ^ then pop out higher priority operators from stack and append
                    while (!st.isEmpty() && priority(c) < priority(st.peek())){
                        postfix.append(st.pop());
                    }
                }
                st.push(c);
            }
        }

        while(!st.isEmpty()){
            postfix.append(st.pop());
        }

        return postfix.toString();
    }

    public static String infixToPrefix(String eq){
        StringBuilder equation = new StringBuilder(eq).reverse();
        for(int i = 0; i < equation.length(); i++){
            if(equation.charAt(i) == '('){
                equation.setCharAt(i, ')');
            }
            else if (equation.charAt(i) == ')') {
                equation.setCharAt(i, '(');
            }
        }
        eq = equation.toString();
        String postfix = infixToPostfix(eq);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPrefix("F+D-C*(B+A)"));
    }
}
