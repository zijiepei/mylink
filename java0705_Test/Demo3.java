package java0705_Test;
class Node3{
    public int key;
    public int value;
    public Node3 left;
    public Node3 right;

    public Node3(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class Demo3 {
    private Node3 root = null;
    public  Node3  find(int key) {
        Node3 cur = root;
        while (cur != null) {
            if(key < cur.key) {
                cur = cur.left;
            }else if(key > cur.key) {
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }
    public Node3 insert(int key,int value) {
        if(root == null) {
            root = new Node3(key,value);
            return root;
        }
        Node3 cur = root;
        Node3  parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                cur.value = value;
                return cur;
            }
        }
        Node3 newNode = new Node3(key,value);
        if(newNode.key < parent.key) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return newNode;
    }
    public void remove(int key) {
        Node3 cur = root;
        Node3 parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                removeNode3(cur,parent);
                return;
            }
        }
        return;
    }

    private void removeNode3(Node3 cur, Node3 parent) {
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
        }else{
            Node3 tizuiyang = cur.right;
            Node3 tizuiyangparent = cur;
            while (tizuiyang.left != null) {
                tizuiyangparent = tizuiyang;
                tizuiyang = tizuiyang.left;
            }
            cur.key = tizuiyang.key;
            cur.value = tizuiyang.value;
            if(tizuiyang == tizuiyangparent.left) {
                tizuiyangparent.left = tizuiyang.right;
            }else {
                tizuiyangparent.right = tizuiyang.right;
            }
        }
    }
}
