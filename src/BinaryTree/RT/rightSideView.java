package BinaryTree.RT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 199.二叉树的右视图（层次）
 */
public class rightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        func(root);
        return list;
    }
    //层次遍历，每到一层的最右边 加入到集合中。
    public List<Integer> list = new ArrayList<>();
    
    public void func(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len;
        int len1;
        while (!queue.isEmpty()){
            len = queue.size();
            len1 = queue.size();
//            TreeNode cur = queue.poll();之前加在这里会导致在每一层中，重复加数据
            int sum = 0;
            while (len > 0 ){
                TreeNode cur = queue.poll();
                sum = sum + cur.val;
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                if (len == 1){
                    list.add(sum / len1);
                }
                len--;
            }
        }
    }
    
  
}
