package Queue1;
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {//链表
    private Node head = new Node(-1);
    private Node tail = head;
    public void offer(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }
    public Integer pop() {
        if(head.next == null) {
            return null;
        }
        Node cur = head.next;
        head.next = cur.next;
        if(head.next == null) {
            tail = head;
        }
        return cur.val;
    }
    public Integer peek() {
        if(head.next == null) {
            return null;
        }
        return head.next.val;
    }
    public boolean isEmpty() {
        return head.next == null;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(9);
        myQueue.offer(5);
        myQueue.offer(2);
        myQueue.offer(7);
        myQueue.offer(3);
        myQueue.offer(6);
        myQueue.offer(8);
        while (!myQueue.isEmpty()) {
            Integer cur = myQueue.pop();
            System.out.print(cur + " ");
        }
    }
}
