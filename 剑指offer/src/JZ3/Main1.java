package JZ3;

import java.util.ArrayList;

class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }
public class Main1 {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       if(listNode == null) {
           return list;
       }
       ListNode cur1 = listNode.next;
       ListNode newHead = listNode;
       while (cur1 != null) {
           ListNode curNext = cur1.next;
           cur1.next = newHead;
           newHead = cur1;
           cur1 = curNext;
       }
       listNode.next = null;
       ListNode cur2 = newHead;
       while (cur2 != null) {
           list.add(cur2.val);
           cur2 = cur2.next;
       }
       return list;
    }
}
