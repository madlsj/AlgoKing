package BinaryTree;

/**
 * 是否平衡二叉树
 * 递归套路
 */
public class IsBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    
    
    public static boolean isBalance(Node head){
        return process(head).isBalanced;
    }
    public static class Info{
        public boolean isBalanced;
        public int height;
        
        public Info(boolean i, int h){
            isBalanced = i;
            height = h;
        }
    }
    
    public static Info process(Node head){
        if (head == null){
            return new Info(true, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        boolean i = false;
        //取左右子树中的最大高度+1，才是我的高度
        int h = Math.max(leftInfo.height, rightInfo.height) + 1;
        //如果左右子树都是平衡， 我自己也要平衡，左子树高度-右子树高度的绝对值 <= 1；
        if (leftInfo.isBalanced && rightInfo.isBalanced && (Math.abs(leftInfo.height - rightInfo.height) < 2)){
            i = true;
        }
        
        return new Info(i, h);
        
    }
    
}
