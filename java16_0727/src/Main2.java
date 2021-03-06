import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
    }
}
public class Main2 {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        for(Node cur = head;cur != null;cur = cur.next) {
            map.put(cur,new Node(cur.val));
        }
        for(Node cur = head;cur != null;cur = cur.next) {
            Node newcur = map.get(cur);
            newcur.next = map.get(cur.next);
            newcur.random = map.get(cur.random);
        }
        return map.get(head);
    }
}
