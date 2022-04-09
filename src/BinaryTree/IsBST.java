package BinaryTree;

import java.util.ArrayList;

/**
 * 是否二叉搜索树
 * 中序遍历并存储在有序集合list中，遍历是否递增.都不能相等吗
 * 递归套路
 */
public class IsBST {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            value = data;
        }
    }
    public static boolean isBst(Node head){
        //中序遍历存在集合中
        if (head == null){
            return true;
        }
        ArrayList<Node> arrayList = new ArrayList<>();
        inOrder(head, arrayList);
        //因为要判断数组是否递增，最好从1开始，避免数组越界！！！
        for (int i = 1; i <  arrayList.size() ; i++){
            if (arrayList.get(i).value <= arrayList.get(i - 1).value){
                return false;
            }
        }
        return true;
        
    }
    
    public static void inOrder(Node head, ArrayList<Node> arrayList){
        if (head == null){
            return;
        }
        inOrder(head.left, arrayList);
        arrayList.add(head);
        inOrder(head.right, arrayList);
    }
    //==========================================================================
    //递归套路
    //正确答案的可能性：左子树是BST，右子树是BST，左边最大值小于我，我大于右边的最大值
    public static class Info{
        boolean isBst;
        int min;
        int max;
        public Info(boolean isBst, int min, int max){
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }
    //当空值不好返回信息时，需要自己一直判断.
    public static Info process(Node x){
        if (x == null){
            return null;//???下面的值都要判断非空！？
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

//忘        boolean isBst = false;
//判        if (leftInfo.isBst && rightInfo.isBst && x.value > leftInfo.max && x.value < rightInfo.min){
//断            isBst = true;
//是        }
//否        int min = Math.min(leftInfo.min, rightInfo.min);
//为        min = Math.min(x.value, min);
//空        int max = Math.max(leftInfo.max, rightInfo.max);
//了        max = Math.max(x.value, max);
        int max = x.value;
        if (leftInfo != null){
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null){
            max = Math.max(max, rightInfo.max);
        }
        int min = x.value;
        if (leftInfo != null){
            min = Math.min(min, leftInfo.max);
        }
        if (rightInfo != null){
            min = Math.min(min, rightInfo.max);
        }
        boolean isBst = true;
        if (leftInfo != null && !leftInfo.isBst){
            isBst = false;
        }
        if (leftInfo != null && x.value <= leftInfo.max){
            isBst = false;
        }
        if (rightInfo != null && !rightInfo.isBst){
            isBst = false;
        }
        if (leftInfo != null && x.value >= leftInfo.min){
            isBst = false;
        }
        
        
        return new Info(isBst, min, max);
    }
    //主函数
    public static boolean isBst2(Node head){
        return process(head).isBst;
    }
}
