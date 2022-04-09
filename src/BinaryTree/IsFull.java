package BinaryTree;

/**
 * 是否满二叉树
 * 1.收集整棵树的高度和总节点数 2^h - 1 = n（为什么不用递归收集）
 * 2.收集子树是不是满二叉树、子树的高度========左树满 && 右树满 && 左右高度相等 -> 整棵树是满的
 */
public class IsFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //我采用层次遍历来获得高度和总节点数???拉跨
    public static class Info{
        int height;
        int nodes;
        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }
    public static Info process(Node x){
        if (x == null){
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }
    public static boolean isFull(Node head){
        Info info = process(head);
        if (Math.pow(2, info.height) - 1  == info.nodes){
            return true;
        }else {
            return false;
        }
    }
    
    
}
