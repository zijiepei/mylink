package TestInterview;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main3 {//////用队列实现栈


        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        public void push(int x) {
            queue1.offer(x);
        }
        public int pop() {
            if (empty()) {
                return 0;
            }
            while (queue1.size() > 1) {

                Integer cur = queue1.poll();
                queue2.offer(cur);
            }
            int top = queue1.poll();
            swap();
            return top;
        }
        public int top() {
            if(empty()) {
                return 0;
            }
            while (queue1.size() > 1) {
                Integer cur = queue1.poll();
                queue2.offer(cur);
            }
            int top = queue1.poll();
            queue2.offer(top);
            return top;
        }
        public void swap () {
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
        }
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
}
