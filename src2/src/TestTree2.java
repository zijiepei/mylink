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
}
