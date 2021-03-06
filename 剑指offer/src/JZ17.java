class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class JZ17 {
    public boolean IsSubTree (TreeNode root1,TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return IsSubTree(root1.left,root2.left) && IsSubTree(root1.right,root2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) {
            return false;
        }
        if(root1 == null) {
            return false;
        }
        boolean flag = IsSubTree(root1,root2);
        return flag || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
}
