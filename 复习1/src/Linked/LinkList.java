package Linked;

import java.math.BigInteger;
import java.util.LinkedList;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class LinkList {
    public Node head;

    public LinkList() {
        this.head = null;
    }
    public Node deelteAllK(int key) {
        if(head == null) {
            return null;
        }
        if(head.val == key) {
            head = head.next;
        }
        Node cur = head.next;
        Node prev = head;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return head;
    }

    public Node reverse() {
        Node prev = null;
        Node cur = head;
        Node newHead = null;
        while (cur != null) {
            Node curnext = cur.next;
            if(curnext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curnext;
        }
        return newHead;
    }

    public Node reverse2() {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        Node cur = head.next;
        Node newHead = head;
        while (cur != null) {
            Node curnext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curnext;
        }
        head.next = null;
        return newHead;
    }

    public Node middleNode() {
        if (head == null) {
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

    public Node getKthtoTail(int k) {
        if(head == null || k <= 0) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        int len = k - 1;
        while (len > 0) {
            if(fast.next != null) {
                fast = fast.next;
                len--;
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

    public Node mergeList(Node head1,Node head2) {
        Node newHead = new Node(-1);
        Node end = newHead;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                end.next = head1;
                head1 = head1.next;
                end = end.next;
            }else {
                end.next = head2;
                head2 = head2.next;
                end = end.next;
            }
        }
        if(head1 == null) {
            end.next = head2;
        }
        if(head2 == null) {
            end.next = head1;
        }
        return newHead.next;
    }

    public Node patitionList(int x) {
        Node beg1 = null;
        Node end1 = null;
        Node beg2 = null;
        Node end2 = null;
        Node cur = head;
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
            return beg2;
        }
        if(beg2 == null && beg1 != null) {
            return beg1;
        }
        end1.next = beg2;
        end2.next = null;
        return beg1;
    }

    public Node deleteLinkedRepet() {
        Node newHead = new Node(-1);
        Node end = newHead;
        Node cur = head;
        while (cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                end.next = cur;
                end = end.next;
                cur = cur.next;
            }
        }
        end.next = null;//防止最后几个是连续重复的
        return newHead.next;
    }

    public boolean isHuiwen() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curnext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curnext;
        }
        while (slow != head) {
            if(head.val != slow.val) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public Node firstCommandNode(Node head1,Node head2) {
        Node curL = head1;
        Node curS = head2;
        int lon = 0;
        int sho = 0;
        while (curL != null) {
            curL = curL.next;
            lon++;
        }
        while (curS != null) {
            curS = curS.next;
            sho++;
        }
        curL = head1;
        curS = head2;
        int len = lon - sho;
        if(len < 0) {
            curL = head2;
            curS = head1;
            len = sho - lon;
        }
        while (len > 0) {
            curL = curL.next;
            len--;
        }
        while (curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        if(curL == null) {
            return null;
        }
        return curL;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    public Node cycleDetect() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
