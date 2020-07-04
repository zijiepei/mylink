package java16_0625;

import java.util.List;
public class Plus2 {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int sum = 0;
        while (p1 != null || p2 != null || sum != 0) {
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            sum /= 10;
        }
        return head.next;
    }
}
