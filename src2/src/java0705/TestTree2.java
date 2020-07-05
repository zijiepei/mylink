import java.util.ArrayList;
import java.util.List;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestTree2 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return (left + right + mid) > 0;
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
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if(leftTail != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(pRootOfTree.right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if(index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index++;
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
    private StringBuffer stringBuffer = new StringBuffer();
    public String tree2str(TreeNode t) {
       if(t == null) {
           return "";
       }
       tree2strHelper(t);
       stringBuffer.deleteCharAt(0);
       stringBuffer.deleteCharAt(stringBuffer.length() - 1);
       return stringBuffer.toString();
    }

    private void tree2strHelper(TreeNode root) {
        if(root == null) {
            return;
        }
        stringBuffer.append("(");
        stringBuffer.append(root.val);
        tree2strHelper(root.left);
        if(root.left == null && root.right != null) {
            stringBuffer.append("()");
        }
        tree2strHelper(root.right);
        stringBuffer.append(")");
    }
    private int index2 = 0;
    private StringBuffer stringBuffer2 = new StringBuffer();
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for(int x : postorder) {
            stringBuffer2.append(x);
        }
       stringBuffer2.reverse();
       for(int i = 0; i < postorder.length;i++) {
           postorder[i] = Integer.parseInt(stringBuffer2.charAt(i) + "");
       }
       index2 = 0;
       return buildTreeHelper2(postorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper2(int[] postorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if(index2 >= postorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(postorder[index2]);
        int pos = find2(inorder,inorderLeft,inorderRight,newNode.val);
        index2++;
        newNode.right = buildTreeHelper2(postorder,inorder,inorderLeft,pos);
        newNode.left = buildTreeHelper2(postorder,inorder,pos + 1,inorderRight);
        return newNode;
    }

    private int find2(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for(int i = inorderLeft; i < inorderRight;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}

