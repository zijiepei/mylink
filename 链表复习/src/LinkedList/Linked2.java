package LinkedList;
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class Linked2 {
    public ListNode head;

    public Linked2() {
        this.head = null;
    }
    public void addFirst(int val) {
        if(head == null) {
            head = new ListNode(val);
        }
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void deletAllkey(int key) {
        if(head == null) {
            return;
        }
        if(head.val == key) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }
    public ListNode reverse() {
        ListNode newHead = head;
        if(head == null) {
            return null;
        }
        ListNode cur = head.next;
        while (cur != null) {
            ListNode curnext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curnext;
        }
        head.next = null;
        return newHead;
    }
    public ListNode reverse2() {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curnext = cur.next;
            if(curnext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curnext;
        }
        return newHead;
    }
    public ListNode middleNode() {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0 || head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
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
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode end = newHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                end.next = l1;
                l1 = l2.next;
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
    public ListNode patition(ListNode phead,int x) {
        ListNode beg1 = null;
        ListNode end1 = null;
        ListNode beg2 = null;
        ListNode end2 = null;
        ListNode cur = phead;
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
        if(beg1 != null && beg2 == null) {
            end1.next = null;
            return beg1;
        }
        end1.next = beg2;
        end2.next = null;
        return beg1;
     }
     public ListNode deleteDupLication(ListNode phead) {
        ListNode newHead = new ListNode(-1);
        ListNode end = newHead;
        ListNode cur = phead;
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
     public boolean chkPalindrome(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curnext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curnext;
        }
        while (slow != A) {
            if(slow.val != A.val) {
                return false;
            }
            if(A.next == slow) {
                return true;
            }
            slow = slow.next;
            A = A.next;
        }
        return true;
     }
     public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lena = 0;
        int lenb = 0;
        ListNode curL = headA;
        ListNode curS = headB;
        while (curL != null) {
            lena++;
            curL = curL.next;
        }
        while (curS != null) {
            lenb++;
            curS = curS.next;
        }
        curL = headA;
        curS = headB;
        int len = lena - lenb;
        if(len < 0) {
            curL = headB;
            curS = headA;
            len = lenb - lena;
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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
     }
     public ListNode detectCycle() {
        ListNode slow = head;
        ListNode fast = head;
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
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
     }
}
