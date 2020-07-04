import java.util.*;

class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {
    public static Node build() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static int size(Node root) {//////////////////////////////////////////////////////////////////////////得到一棵树里面的节点个数
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    public static int leafSize(Node root) {////////////////////////////////////////////////////////////////////////////////求一棵树中叶子节点的个数
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
    public static int klevelSize(Node root,int k) {///////////////////////////////////////////////////////////////////////求一棵树第K层的节点个数
        if(k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return klevelSize(root.left,k - 1) + klevelSize(root.right,k  - 1);
    }
    public static Node Tofind(Node root,char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        Node ret = Tofind(root.left,val);
        if(ret != null) {
            return ret;
        }
        return Tofind(root.right,val);
    }
//    public List<Integer> preorderTraversal(TreeNode root) {/////////////////////////////////////////////////////////先序遍历
//           List<Integer> list = new ArrayList<>();
//           if(root == null) {
//               return list;
//           }
//           list.add(root.val);
//           list.addAll(preorderTraversal(root.left));
//           list.addAll(preorderTraversal(root.right));
//           return list;
//    }
/*public List<Integer> preorderTraversal(TreeNode root) {/////////////////////////////////////////////////////////先序遍历
           List<Integer> list = new ArrayList<>();
         if(root == null) {
               return list;
           }

           list.addAll(preorderTraversal(root.left));
           list.add(root.val);
           list.addAll(preorderTraversal(root.right));
           return list;
    }*/
    public boolean isSameTree(Node p, Node q) {/////////////////////////////////////////////////////////////////////////////检查两棵树是否相同
          if(p == null && q == null) {
              return true;
          }
          if(p == null || q == null) {
              return false;
          }
          if(p.val != q.val) {
              return false;
          }
          return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(Node s, Node t) {/////////////////////////////////////////////////////////判断t是否是s的子树
          if(s == null && t == null) {
              return true;
          }
          if(s == null || t == null) {
              return false;
          }
          boolean ret = false;
          ret = isSameTree(s,t);
          return ret || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public int maxDepth(Node root) {/////////////////////////////////////////////////////////////////////////////求树的最大深度
         if(root == null) {
             return 0;
         }
         if(root.left == null && root.right == null) {
             return 1;
         }
         int leftDepth = maxDepth(root.left);
         int rightDepth = maxDepth(root.right);
         return 1 + (Math.max(leftDepth, rightDepth));
    }
    public boolean isBalanced(Node root) {//////////////////////////////////////////////////////////////////////////求一个树是否是平衡二叉树
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public boolean isSymmetric(Node root) {////////////////////////////////////////////////////////////////////////求一个二叉树的左右子树是否镜像
         if(root == null) {
             return true;
         }
         return isMirro(root.left,root.right);
    }

    private boolean isMirro(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return isMirro(t1.left,t2.right) && isMirro(t1.right,t2.left);
    }
    public void levelOrder(Node root) {///////////////////////////////////////////////////用一个队列来实现层序遍历
        Queue<Node> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            queue.offer(root);
            Node cur = queue.poll();
            System.out.print(cur + " ");
            if(root.left != null) {
                queue.offer(cur.left);
            }
            if(root.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    public boolean isComplete(Node root) {///////////////////////////判断完全二叉树
        Queue<Node> queue = new LinkedList<>();
        boolean steptwo = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!steptwo) {
                queue.offer(root);
                if (root.left != null && root.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                }else if(cur.left == null && cur.right == null) {
                    return false;
                }else if (cur.left != null && cur.right == null) {
                    steptwo = true;
                    queue.offer(cur.left);
                }else {
                    steptwo = true;
                }
            } else {
                if (root.left != null || root.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int index = 0;
    public static Node creatTreeperorder(String string) {
        char c = string.charAt(index);
        if(c == '#') {
            return null;
        }
        Node root = new Node(c);
        index++;
        root.left = creatTreeperorder(string);
        index++;
        root.right = creatTreeperorder(string);
        return root;
    }
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        //Node root = build();
        //TreeNode root1 = build2();
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            index = 0;
            Node root = creatTreeperorder(s);
            inOrder(root);
            System.out.println();
        }
    }
}
