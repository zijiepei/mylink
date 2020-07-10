package Stack;
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyStack2 {//链表
    Node head = new Node(-1);
    public void push(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }
    public Integer pop() {
        if(head.next == null) {
            return null;
        }
        Node cur = head.next;
        head.next = cur.next;
        return cur.val;
    }
    public Integer peek() {
        if(head.next == null) {
            return null;
        }
        Node cur = head.next;
        return cur.val;
    }
    public boolean empty() {
        return head.next == null;
    }

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(9);
        myStack2.push(5);
        myStack2.push(2);
        myStack2.push(7);
        myStack2.push(3);
        myStack2.push(6);
        myStack2.push(8);
        while (!myStack2.empty()) {
            Integer cur = myStack2.pop();
            System.out.print(cur + " ");
        }
    }
}
