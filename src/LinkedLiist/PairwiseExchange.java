package LinkedLiist;

/**
 * 24.两两交换链表中点节点。https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 哨兵节点（涉及到换头的？）---看似两两交换，实际上涉及到三个节点位置！
 */

public class PairwiseExchange {
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
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummpyNode = new ListNode();
        dummpyNode.next = head ;
        ListNode cur = head;
        ListNode pre = dummpyNode;
        while (pre.next != null && pre.next.next !=null){
            ListNode temp = cur.next;
            pre.next = temp;
            cur.next = temp.next;
            temp.next = cur;
            //交换结束，向前走
            pre = pre.next.next;
            cur = pre.next;
        }
        return dummpyNode.next;
        
        

    }

}
