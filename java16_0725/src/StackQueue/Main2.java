package StackQueue;

import java.util.Stack;

public class Main2 {///用栈实现队列

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        public void offer(int val) {
            while (!stack2.isEmpty()) {
                Integer top = stack2.pop();
                stack1.push(top);
            }
            stack1.push(val);
        }
        public Integer poll() {
            if(empty()) {
                return null;
            }
            while (!stack1.isEmpty()) {
                Integer top = stack1.pop();
                stack2.push(top);
            }
            return stack2.pop();
        }
        public Integer peek() {
            if(empty()) {
                return null;
            }
            while (!stack1.isEmpty()) {
                Integer top = stack1.pop();
                stack2.push(top);
            }
            return stack2.peek();
        }
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
}
