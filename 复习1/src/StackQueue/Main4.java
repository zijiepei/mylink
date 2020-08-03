package StackQueue;

import java.util.Stack;

public class Main4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int x) {
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

    public void pop() {
        if(stack1.isEmpty()) {
            return;
        }
        stack1.pop();
        stack2.pop();
    }
    public int top() {
        if(stack1.isEmpty()) {
            return 0;
        }
        return stack1.peek();
    }
    public int getMin() {
        if(stack2.isEmpty()) {
            return 0;
        }
        return stack2.peek();
    }
}
