import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TestTree {
    public static int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    public static int leafSize(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
    public static int Klevesize(TreeNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return Klevesize(root.left,k - 1) + Klevesize(root.right,k - 1);
    }
    public static TreeNode toFind(TreeNode root,int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode ret = toFind(root.left,val);
        if(ret != null) {
            return ret;
        }
        return toFind(root.right,val);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         if(root == null) {
             return list;
         }
         list.add(root.val);
         list.addAll(preorderTraversal(root.left));
         list.addAll(preorderTraversal(root.right));
         return list;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p == null && q == null) {
             return true;
         }
         if(p == null || q == null) {
             return false;
         }
         if(q.val != p.val) {
             return false;
         }
         return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
         if(s == null && t == null) {
             return true;
         }
         if(s == null || t == null) {
             return false;
         }
         boolean ret = isSameTree(s,t);
         return ret || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if( left - right > 1 || left - right < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
     }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirro(root.left,root.right);
    }

    private boolean isMirro(TreeNode left, TreeNode right) {
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
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(root.left != null) {
                queue.offer(root.left);
            }
            if(root.right != null) {
                queue.offer(root.right);
            }
        }
    }
    public boolean iscomPlete(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && root.right != null) {
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
    public static  TreeNode creatTreepreorder(String string) {
        char c = string.charAt(index);
        if(c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = creatTreepreorder(string);
        index++;
        root.right = creatTreepreorder(string);
        return root;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) {
            return result;
        }
        levelOrderHelper(root,0);
        return result;
    }
    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> row = result.get(level);
        row.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left,level + 1);
        }
        if(root.right != null) {
            levelOrderHelper(root.right,level + 1);
        }
    }
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid > 0);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && left.right != null) {
            leftTail = leftTail.right;
        }
        if(leftTail != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.right = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(pRootOfTree.right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
    StringBuffer sb = new StringBuffer();
    public String tree2str(TreeNode t) {
       if(t == null) {
           return "";
       }
       tree2strHelper(t);
       sb.deleteCharAt(0);
       sb.deleteCharAt(sb.length() - 1);
       return sb.toString();
    }

    private void tree2strHelper(TreeNode t) {
        if(t == null) {
            return;
        }
        sb.append("(");
        sb.append(t.val);
        tree2strHelper(t.left);
        if(t.left == null && t.right != null) {
            sb.append("()");
        }
        tree2strHelper(t.right);
        sb.append(")");
    }
    private int index2 = 0; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index2 = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if(index2 >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index2]);
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index2++;
        newNode.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        newNode.right = buildTreeHelper(preorder,inorder,pos + 1,inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for(int i = inorderLeft;i < inorderRight;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
