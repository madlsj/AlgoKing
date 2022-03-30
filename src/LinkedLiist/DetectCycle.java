package LinkedLiist;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 142.环形链表2
 */

public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //笔试思路，hashset！
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (hashSet.contains(cur)){
                break;
            }
            hashSet.add(cur);
            cur = cur.next;
        }
        return cur;
    }
    //面试思路，快慢指针：判断条件需要搞一下
    public ListNode detectCycle2(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){ //确定不会空指针异常。确保有next指针，
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
            
            
        }
        return null;
        
    }
}
