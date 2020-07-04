package java16_0626;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main1 {
    public int TreeNodeDepth(TreeNode root) {//////////////求一棵树的高度
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = TreeNodeDepth(root.left);
        int rightDepth = TreeNodeDepth(root.right);
        return 1 + (Math.max(leftDepth, rightDepth));
    }
    public boolean isBalance(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = TreeNodeDepth(root.left);
        int rightDepth = TreeNodeDepth(root.right);
        if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
