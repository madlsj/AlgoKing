package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public Queue<String> serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<String> ans = new LinkedList<String>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ans.offer(String.valueOf(root.val));
        queue.offer(root);
        TreeNode cur ;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur.left != null){
                ans.offer(String.valueOf(cur.left.val));
                queue.offer(cur.left);
            }else {
                ans.offer(null);
            }
            if (cur.right != null){
                ans.offer(String.valueOf(cur.right.val));
                queue.offer(cur.right);
            }else {
                ans.offer(null);
            }
            
        }
        return ans;
        
    }
    public TreeNode deserialize(Queue<String> data) {
        if (data == null || data.size() == 0){
            return null;
        }
        TreeNode root = generateTreenode(data.poll());
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            cur.left = generateTreenode(data.poll());
            cur.right = generateTreenode(data.poll());
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return root;
    }
    
    public TreeNode generateTreenode(String val){
        if (val == null){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

}
