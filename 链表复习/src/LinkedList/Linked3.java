package LinkedList;

class Node2 {
    public int val;
    public Node2 next;

    public Node2(int val) {
        this.val = val;
    }
}
public class Linked3 {
    public Node2 head;
    public void deleteAllkey(int key) {
        if(head == null) {
            return;
        }
        Node2 prev = head;
        Node2 cur = prev.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
    }
    public Node2 reverse() {
        if(head == null) {
            return null;
        }
        Node2 newHead = head;
        Node2 cur = head.next;
        while (cur != null) {
            Node2 curnext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curnext;
        }
        head.next = null;
        return newHead;
    }
    public Node2 reverse2() {
        Node2 cur = head;
        Node2 prev = null;
        Node2 newHead = null;
        while (cur != null) {
            Node2 curnext = cur.next;
            if(curnext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curnext;
        }
        return newHead;
    }
    public Node2 middleNode() {
        if(head == null) {
            return null;
        }
        Node2 slow = head;
        Node2 fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node2 findKtoTail(Node2 head,int k) {
        if(head == null) {
            return null;
        }
        Node2 slow = head;
        Node2 fast = head;
        while (k - 1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                return null;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public Node2 mergTwoList(Node2 l1,Node2 l2) {
        Node2 newHead = new Node2(-1);
        Node2 end = newHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                end.next = l1;
                l1 = l1.next;
                end = end.next;
            }else {
                end.next = l2;
                l2 = l2.next;
                end = end.next;
            }
        }
        if(l1 == null) {
            end.next = l2;
        }
        if(l2 == null) {
            end.next = l1;
        }
        return newHead.next;
    }
}
