package java16_0623;
class Node {
    public int val;
    public Node next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public Node (int val) {
        this.val = val;
        this.next = null;
    }
}
public class Main2 {
    public Node partition(Node pHead, int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = pHead;
        while (cur != null) {
            if(cur.val < x) {
                if(bs == null) {
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null && as != null) {
            ae.next = null;
            return as;
        }
        if(bs != null && as == null) {
            be.next = null;
            return bs;
        }
        be.next = as;
        ae.next = null;
        return bs;
    }
}
