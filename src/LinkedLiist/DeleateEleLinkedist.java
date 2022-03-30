package LinkedLiist;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 203.移除链表元素
 * 哨兵结点。。。
 */

public class DeleateEleLinkedist {
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
    public ListNode removeElements(ListNode head, int val){
        ListNode dummpyHead = new ListNode();
        dummpyHead.next = head;
        ListNode cur;
        cur = dummpyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummpyHead.next;

    }
  
}
