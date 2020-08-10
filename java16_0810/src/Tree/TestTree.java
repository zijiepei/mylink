package Tree;

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
public class TestTree {
    public Node root = null;
    public static void preOder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        preOder(root.left);
        preOder(root.right);
    }

    public static void preOderByLoop(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.val);
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static int size(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static int leafSize(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    public static int KlevelSize(Node root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return KlevelSize(root.left,k - 1) + KlevelSize(root.right,k - 1);
    }

    public static Node toFind(Node root,int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        Node ret = toFind(root.left,val);
        if(ret != null) {
            return ret;
        }
        return toFind(root.right,val);
    }

    public List<Integer> preorDerTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorDerTraversal(root.left));
        list.addAll(preorDerTraversal(root.right));
        return list;
    }

    public boolean sameTree(Node root1,Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return sameTree(root1.left,root2.left) && sameTree(root1.right,root2.right);
    }

    public boolean isSubTree(Node s,Node t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        boolean ret = sameTree(s,t);
        return ret || isSubTree(s.left,t) || isSubTree(s.right,t);
    }

    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left,right);
    }

    public boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left - right > 1 || left - right < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetric(Node root) {
        if(root == null) {
            return true;
        }
        return isMirro(root.left,root.right);
    }
    private boolean isMirro(Node left, Node right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isMirro(left.left,right.right) && isMirro(left.right,right.left);
    }

    public void levelOder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if(root.left != null) {
                queue.offer(root.left);
            }
            if(root.right != null) {
                queue.offer(root.right);
            }
        }
    }

    public boolean isComplete(Node root) {
        if(root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean isFirstStep = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null) {
                    return false;
                }else if(cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                }else {
                    isFirstStep = false;
                }
            }else {
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int index = 0;
    public static Node creatNodeOder(String string) {
        char c = string.charAt(index);
        if(c == '#') {
            return null;
        }
        Node root = new Node(c);
        index++;
        root.left = creatNodeOder(string);
        index++;
        root.right = creatNodeOder(string);
        return root;
    }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOder2(Node root) {
        if(root == null) {
            return result;
        }
        levelOder2Helper(root,0);
        return result;
    }

    private void levelOder2Helper(Node root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> row = result.get(level);
        row.add(root.val);
        if(root.left != null) {
            levelOder2Helper(root.left,level + 1);
        }
        if(root.right != null) {
            levelOder2Helper(root.right,level + 1);
        }
    }

    private Node lca = null;
    public Node lowestCommonAncestor(Node root,Node p,Node q) {
        if(root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }

    private boolean findNode(Node root, Node p, Node q) {
        if(root == null) {
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
        return left + right + mid > 0;
    }
}
