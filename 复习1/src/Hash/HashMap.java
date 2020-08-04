package Hash;
class Node {
    public int key;
    public int val;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class HashMap {
    Node[] array = new Node[101];
    public int size = 0;
    public void put(int key,int val) {
        int index = hasFuc(key);
        Node head = array[index];
        for(Node cur = head;cur != null;cur = cur.next) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
        }
        Node newNode = new Node(key,val);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
    }

    private int hasFuc(int key) {
        return key % array.length;
    }

    public Integer get(int key) {
        int index = hasFuc(key);
        Node head = array[index];
        for(Node cur = head;cur != null;cur = cur.next) {
            if(cur.key == key) {
                return cur.val;
            }
        }
        return null;
    }
}
