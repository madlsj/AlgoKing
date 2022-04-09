package LinkedLiist;

import java.util.Stack;

/**
 * 234.回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindromeList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
      //笔试思路 不就是逆序判断 
      //引入栈

    /**
     * 有问题
     */
    public boolean isPalindrome(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //面试思路，判断中点，？？
    public boolean isPalindrome2(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        if (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 打断链表
        n2 = n1.next;
        n1.next = null;
        //打断的右边逆序
        ListNode n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1 ;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1 ;
        n2 = head;
        boolean res = true;
        while (n2 != null && n1 !=null ){
            if (n2.val != n1.val){
                res = false;
                break;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;        
        
        
    }

    /**
     * 官方题解
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
       
    
   
}
