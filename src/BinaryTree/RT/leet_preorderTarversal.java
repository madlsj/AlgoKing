package BinaryTree.RT;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 144.二叉树前序遍历
 */
public class leet_preorderTarversal {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }
    
    public void process(TreeNode root, List<Integer> list){
          if (root == null){
              return;
          }
          list.add(root.val);
          process(root.left, list);
          process(root.right, list);
    }
}
