package StackQueue;

import java.util.Stack;

public class Main1 {
    public boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
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
            if(top == '(' && c == ')') {
                continue;
            }
            if(top == '[' && c == ']') {
                continue;
            }
            if(top == '{' && c == '}') {
                continue;
            }
           return false;
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
