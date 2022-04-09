package BinaryTree.RT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 剑指32.从上到下打印二叉树
 */
public class LevelPrint1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int itemLength;
        ArrayList<Integer>res = new ArrayList();
        while (!queue.isEmpty()){
            itemLength = queue.size();
            while (itemLength > 0){
                cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                itemLength--;
            }
        }
        int [] resList = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            resList[i] = res.get(i);
        }
        
        return resList;
    }
    
    
    
}
