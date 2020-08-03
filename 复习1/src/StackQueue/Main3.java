package StackQueue;

import java.util.Queue;
import java.util.Stack;

public class Main3 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void offer(int x) {
        while (!stack2.isEmpty()) {
            int top = stack2.pop();
            stack1.push(top);
        }
        stack1.push(x);
    }
    public Integer poll() {
        while (!stack1.isEmpty()) {
            Integer top = stack1.pop();
            stack2.push(top);
        }
        Integer cur = stack2.pop();
        return cur;
    }
    public Integer peek() {
        while (!stack1.isEmpty()) {
            Integer top = stack1.pop();
            stack2.push(top);
        }
        return stack2.peek();
    }
}
