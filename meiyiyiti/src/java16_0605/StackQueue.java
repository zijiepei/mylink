package java16_0605;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void offer(int node) {
        while (!stack2.empty()) {
            int cur = stack2.pop();
            stack1.push(cur);
        }
        stack1.push(node);
    }

    public int poll() {
        while (!stack1.empty()) {
            int cur = stack1.pop();
            stack2.push(cur);
        }
       return stack2.pop();
    }
}
