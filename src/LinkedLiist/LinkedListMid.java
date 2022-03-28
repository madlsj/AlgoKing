package LinkedLiist;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣876 链表的中间结点https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
class LinkedListMid {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * 笔试做法
     */
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        while (cur!=null){
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size()/2);
    }

    /**
     * 面试做法
     */
    
    public ListNode middleNode1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
