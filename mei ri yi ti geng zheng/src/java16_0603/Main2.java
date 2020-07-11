package java16_0603;

import java.util.Stack;

public class Main2 {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        if(A == null && A.length() != n) {
            return false;
        }
        for(int i = 0;i < A.length();i++) {
            char c = A.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else if(c == ')') {
                if(stack.empty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}
