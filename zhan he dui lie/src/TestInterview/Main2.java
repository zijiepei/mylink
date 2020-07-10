package TestInterview;

import java.util.Stack;

public class Main2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            Character top = stack.pop();
            if(c == ')' && top == '(') {
                continue;
            }
            if(c == ']' && top == '[') {
                continue;
            }
            if(c == '}' && top == '{') {
                continue;
            }
            return false;
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
