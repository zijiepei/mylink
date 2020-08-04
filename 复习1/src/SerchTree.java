class Node {
   public int key;
   public int val;
   public Node left;
   public Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class SerchTree {
    public Node root = null;
    public Node find(int key) {
        Node cur = root;
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

    public Node insert(int key,int val) {
        if(root == null) {
            root = new Node(key,val);
            return root;
        }
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
                cur.val = val;
                return cur;
            }
        }
        Node newNode = new Node(key,val);
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
            }else if(key >cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                removeNode(cur,parent);
                return;
            }
        }
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
            Node tizuiyang = cur.right;
            Node tizuiyangParent = cur;
            while (tizuiyang.left != null) {
                tizuiyangParent = tizuiyang;
                tizuiyang = tizuiyang.left;
            }
            cur.key = tizuiyang.key;
            cur.val = tizuiyang.val;
            if(tizuiyang == tizuiyangParent.left) {
                tizuiyangParent.left = tizuiyang.right;
            }else {
                tizuiyangParent.right = tizuiyang.right;
            }
        }
    }
}
