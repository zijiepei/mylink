package java0705_Test;

public class Demo1 {
    static class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node root = null;
    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                cur = cur.left;
            } else if (key > cur.key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
    public  Node insert(int key,int value) {
        if(root == null) {
            root = new Node(key,value);
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            }else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                cur.value = value;
                return cur;
            }
        }
        Node newNode = new Node(key,value);
        if(newNode.key < parent.key) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return newNode;
    }
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                removeNode(cur,parent);
                return;
            }
        }
        return;
    }

    private void removeNode(Node cur, Node parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else if(cur == parent.right) {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else if(cur == parent.right) {
                parent.right = cur.left;
            }
        }else {
            Node scapeGoat = cur.right;
            Node scapeGoatparent = cur;
            while (scapeGoat.left != null) {
                scapeGoatparent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            cur.key = scapeGoat.key;
            cur.value = scapeGoat.value;
            if(scapeGoat == scapeGoatparent.left) {
                scapeGoatparent.left = scapeGoat.right;
            }else {
                scapeGoatparent.right = scapeGoat.right;
            }
        }
    }
}
