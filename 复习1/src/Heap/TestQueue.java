package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
