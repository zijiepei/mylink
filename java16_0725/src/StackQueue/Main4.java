package StackQueue;

import java.util.Stack;

public class Main4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void pushx(int x) {
        stack1.push(x);
        if(stack2.isEmpty()) {
            stack2.push(x);
            return;
        }
        Integer min = stack2.peek();
        if(x < min) {
            min = x;
        }
        stack2.push(min);
    }
    public Integer popx() {
        if(stack1.isEmpty()) {
            return null;
        }
        stack2.pop();
        return stack1.pop();
    }
    public Integer peek() {
        if(stack1.isEmpty()) {
            return null;
        }
        return stack1.peek();
    }
    public int GetMin() {
        if(stack2.isEmpty()) {
            return 0;
        }
        return stack2.peek();
    }
}
