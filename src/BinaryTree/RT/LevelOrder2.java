package BinaryTree.RT;

import java.util.*;

/**
 * 107层序遍历2.
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */

public class LevelOrder2 {
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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        func01(root);
        Collections.reverse(resList);
        return resList;
    }

    public void func01(TreeNode node) {
        if(node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int lenth = queue.size();
            List<Integer> itemList = new ArrayList<Integer>();
            TreeNode cur;
            while (lenth > 0) {
                cur = queue.poll();
                itemList.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                lenth--;
            }
            resList.add(itemList);

        }

    }

}
