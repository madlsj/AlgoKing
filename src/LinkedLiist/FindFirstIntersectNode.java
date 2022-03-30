package LinkedLiist;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160.相交链表
 */

public class FindFirstIntersectNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur;
        cur = headA;
        while (cur != null) {
            hashSet.add(cur);
            cur = cur.next;
        }
        cur = headB;
        //判断hashset里面是否包含某个元素，不要每次都遍历！
        //有特定方法，hashset.contains
//        while (cur != null){
//            for (ListNode inSetNode: hashSet){
//                if(cur == inSetNode){
//                    return cur;
//                }
//            }
//            cur = cur.next;
//        }
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    //***面试做法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //记录两条链表的长度
        int lengthA = 0;
        int lengthB = 0;
        ListNode cur = headA;
        ListNode curhelp = headB;
        while (cur != null) {
            cur = cur.next;
            lengthA++;
        }
        while (curhelp != null) {
            curhelp = curhelp.next;
            lengthB++;
        }
        if (cur != curhelp){
            return null;
        }
        //差值
        int dif = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            cur = headA;
            curhelp = headB;
        } else {
            cur = headB;
            curhelp = headA;
        }
        for (int i = 0; i < dif; i++) {
            cur = cur.next;
        }
        while (cur != null && curhelp != null){
            if (cur == curhelp){
                break;
            }
            cur = cur.next;
            curhelp = curhelp.next;
        }
        return cur;

    }


}
