import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
           return arrayList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            arrayList.add(cur.val);
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return arrayList;
    }
}
