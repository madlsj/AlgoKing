package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 二叉树最低公共祖先
 */
//单链表相交问题
public class LowestCommonAncestor {
    //
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //得到一个HashMap，存着每个结点向上走的路
    //记录好o1向上走的路，存到Hashset里
    //看o2向上走，第一次相交的结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        fillParentMap(root, parentMap);
        parentMap.put(root, null);
        HashSet<TreeNode> pSet = new HashSet<TreeNode>();
        TreeNode cur = p;
        pSet.add(p);
        while (parentMap.get(cur) != null){
            cur = parentMap.get(cur);
            pSet.add(cur);
        }
        cur = q;
        while (!pSet.contains(cur)){
            cur = parentMap.get(cur);
        }
        return cur;
        
    }
    
    public void fillParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        if (root == null){
            return;
        }
        if (root.left != null){
            parentMap.put(root.left, root);
        }
        if (root.right != null){
            parentMap.put(root.right, root);
        }
        fillParentMap(root.left, parentMap);
        fillParentMap(root.right, parentMap);
    }

}
