public class MyhashMap {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node[] array = new Node[101];
    public int size = 0;
    public void put(int key,int value) {
       int index = hashFuc(key);
       Node head = array[index];
       for(Node cur = head;cur != null;cur = cur.next) {
           if(cur.key == key) {
               cur.value = value;
               return;
           }
       }
       Node newnode = new Node(key,value);
       newnode.next = array[index];
       array[index] = newnode;
       size++;
    }

    private int hashFuc(int key) {
        return key % array.length;
    }
    public Integer get(int key) {
        int index = hashFuc(key);
        Node head = array[index];
        for(Node cur = head;cur != null; cur = cur.next) {
            if(cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}
