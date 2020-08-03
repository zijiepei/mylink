package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public void push(int x) {
        queue1.offer(x);
    }
    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (queue1.size() > 1) {
            Integer top = queue1.poll();
            queue2.offer(top);
        }
        int top = queue1.poll();
        swap();
        return top;
    }

    public Integer peek() {
        if(empty()) {
            return null;
        }
        while (queue1.size() > 1) {
            Integer top = queue1.poll();
            queue2.offer(top);
        }
        int top = queue1.poll();
        queue2.offer(top);
        swap();
        return top;
    }
    private void swap() {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    private boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
