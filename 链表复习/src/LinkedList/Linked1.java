package LinkedList;
class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class Linked1 {
    public Node head;
    public Linked1() {
        head = null;
    }
    public void addFirst(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            return;
        }else {
            node.next = this.head;
            head = node;
        }
    }
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void removeAllval(int val) {///删除所有值为val的节点
       if(this.head == null) {
           return;
       }
       Node prev = head;
       Node cur = prev.next;
       while (cur != null) {
           if(cur.val == val) {
               prev.next = cur.next;
               cur = cur.next;
           }else {
               prev = prev.next;
               cur = cur.next;
           }
       }
       if(head.val == val) {
           head = head.next;
       }
    }
    public Node revrse() {
        Node newhead = head;
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return newhead;
        }
        Node cur = head.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = curNext;
        }
        head.next = null;
        return newhead;
    }
    public Node revrse2() {
        Node cur = head;
        Node prev = null;
        Node newNode = null;
        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newNode = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newNode;
    }
    public Node middleNode() {
        if(head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node FindKthToTail(Node head,int k) {
        if(k <= 0 || head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
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
    public Node mergeTwoLists(Node l1, Node l2) {
        Node newHead = new Node(-1);
        Node end = newHead;
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
    public Node partition(Node pHead, int x) {
        Node beg1 = null;
        Node end1 = null;
        Node beg2 = null;
        Node end2 = null;
        Node cur = pHead;
        while (cur != null) {
            if(cur.val < x) {
                if(beg1 == null) {
                    beg1 = cur;
                    end1 = cur;
                }else {
                    end1.next = cur;
                    end1 = end1.next;
                }
            }else {
                if(beg2 == null) {
                    beg2 = cur;
                    end2 = cur;
                }else {
                    end2.next = cur;
                    end2 = end2.next;
                }
            }
            cur = cur.next;
        }
        if(beg1 == null && beg2 != null) {
            end2.next = null;
            return beg2;
        }
        if(beg2 == null && beg1 != null) {
            end1.next = null;
            return beg1;
        }
        if(beg1 != null && beg2 != null) {
            end1.next = beg2;
            end2.next = null;
        }
        return beg1;
    }
    public static void main(String[] args) {
        Linked1 linked1 = new Linked1();
        linked1.addFirst(1);
        linked1.addFirst(1);
        linked1.addFirst(2);
        linked1.addFirst(3);
        linked1.addFirst(2);
        linked1.addFirst(3);
        linked1.addFirst(4);
        linked1.addFirst(4);
        linked1.display();
        System.out.println();
        //linked1.removeAllval(4);
        linked1.display2(linked1.revrse());
    }
}
