package LinkedLiist;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 138.复制带随机指针的链表
 */

public class CopyListWithRandom {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //笔试做法
    public static Node copyRandomList(Node head){
        //key 老节点 value克隆的新节点
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //第二遍 遍历
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    //面试做法。。今天头有点疼。。
}
