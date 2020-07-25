package StackQueue;
import java.util.*;
public class Main3 {//用队列实现栈
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public void push(int val) {
        queue1.offer(val);
    }
    public Integer pop() {
        if(empy()) {
            return null;
        }
        while (queue1.size() > 1) {
            Integer cur = queue1.poll();
            queue2.offer(cur);
        }
        swap();
        return queue1.poll();
    }
    private void swap() {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }
    public Integer peek() {
        if (empy()) {
            return null;
        }
        while (queue1.size() > 1) {
            Integer cur = queue1.poll();
            queue2.offer(cur);
        }
        Integer top = queue1.poll();
        queue2.offer(top);
        return top;
    }
    public boolean empy() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
