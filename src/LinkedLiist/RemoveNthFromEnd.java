package LinkedLiist;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19.删除链表的倒数第N个结点。
 * 涉及到删除：哨兵+前驱
 * 设计到特殊位置：快慢指针
 */

public class RemoveNthFromEnd {
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
    //存哈希map太浪费空间了，不如计算长度。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpyNode = new ListNode();
        dummpyNode.next = head;
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int length = 0 ;
        ListNode cur = dummpyNode;
        while (cur != null){
            hashMap.put(length++ , cur);
            cur = cur.next;
        }
        if (n >= length || n <= 0){
            return dummpyNode.next;
        }
        cur = hashMap.get((length-n-1));
        cur.next = cur.next.next;
        return dummpyNode.next;
        
    }
    
    //****快慢指针*******
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummpyNode = new ListNode();
        dummpyNode.next = head;
        ListNode slow = dummpyNode;
        ListNode fast = dummpyNode;
        for (int i = 0; i < n ; i++){
            fast = fast.next;
        }
        while (fast.next !=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummpyNode.next;
    }
}
