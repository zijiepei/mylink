package JZ16;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode end = head;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                end.next = list1;
                end = list1;
                list1 = list1.next;
            }else {
                end.next = list2;
                end = list2;
                list2 = list2.next;
            }
        }
        if(list1 == null) {
            end.next = list2;
        }
        if(list2 == null) {
            end.next = list1;
        }
        return head.next;
    }
}
