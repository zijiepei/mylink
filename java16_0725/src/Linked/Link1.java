package Linked;
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class Link1 {
    public Node head = null;

    public void deleteallKey(int k) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.val == k) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if (head.val == k) {
            head = head.next;
        }
    }

    public Node reverse() {
        Node prev = null;
        Node cur = head;
        Node newHead = null;
        while (cur != null) {
            Node curnext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curnext;
        }
        return newHead;
    }

    public Node reverse2() {
        Node newHead = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node cur = head.next;
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
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node findKthToTail(int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node mergeTowList(Node l1, Node l2) {
        Node newHead = new Node(-1);
        Node end = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                end.next = l1;
                end = end.next;
                l1 = l1.next;
            } else {
                end.next = l2;
                end = end.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            end.next = l2;
        }
        if (l2 == null) {
            end.next = l1;
        }
        return newHead.next;
    }

    public Node patition(Node phaed, int x) {
        Node beg1 = null;
        Node end1 = null;
        Node beg2 = null;
        Node end2 = null;
        Node cur = phaed;
        while (cur != null) {
            if (cur.val < x) {
                if (beg1 == null) {
                    beg1 = cur;
                    end1 = cur;
                } else {
                    end1.next = cur;
                    end1 = end1.next;
                }
            } else {
                if (beg2 == null) {
                    beg2 = cur;
                    end2 = cur;
                } else {
                    end2.next = cur;
                    end2 = end2.next;
                }
            }
            cur = cur.next;
        }
        if (beg1 != null && beg2 == null) {
            end1.next = null;
            return beg1;
        }
        if (beg1 == null && beg2 != null) {
            end2.next = null;
            return beg2;
        }
        end1.next = beg2;
        end2.next = null;
        return beg1;
    }
    public Node deleteDupLication(Node phead) {
        Node newHead = new Node(-1);
        Node end = newHead;
        Node cur = phead;
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
        end.next = null;
        return newHead.next;
    }
    public boolean chkPalindrom(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
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
            if(slow.val != head.val) {
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
    public Node getintersectionNode(Node headA,Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        Node curL = headA;
        Node curS = headB;
        while (curL != null) {
            lenA++;
            curL = curL.next;
        }
        while (curS != null) {
            lenB++;
            curS = curS.next;
        }
        curL = headA;
        curS = headB;
        int len = lenA - lenB;
        if(len < 0) {
            curL = headB;
            curS = headA;
            len = lenB - lenA;
        }
        while (len > 0) {
            curL = curL.next;
            len--;
        }
        while (curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        if(curL != null) {
            return curL;
        }
        return null;
    }
    public boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null && fast.next == null) {
            return false;
        }
        return true;
    }
    public Node detecCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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
        return fast;
    }
}
