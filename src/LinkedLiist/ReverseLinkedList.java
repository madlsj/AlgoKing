package LinkedLiist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 206.反转链表
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        if (head == null || head.next ==null){
            return head;
        }
        while (cur != null){
            temp = cur.next;
            cur.next = pre ;
            pre = cur;
            cur = temp;
        }
        return pre;
        
    }    
}
