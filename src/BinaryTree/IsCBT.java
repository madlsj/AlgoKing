package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 * 层次遍历（用这个）！！
 * 递归套路（好麻烦）
 */
public class IsCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            value = data;
        }
    }
    //层次遍历 判断结点 如果有右无左则不是  如果有左无右则后面都必须是叶节点
    //也就是判断是否遇到过左右不双全的结点，遇到之后，情形发生变化。进入情形二
    public static boolean isCbt(Node head){
        if(head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean leaf = false;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
            //代码优化：是否可以合并
            if (cur.right != null && cur.left == null){
                return false;
            }
            if (leaf && (cur.left != null|| cur.right != null)){
                return false;
            }
            //一样的，最后才变
            if (cur.left == null || cur.right == null){
                leaf = true;
            }
        }
       return true; 
    }
    
    //递归套路练习：
    
}
