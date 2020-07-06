package java0706;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o)) ;
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
        }
    }
}
