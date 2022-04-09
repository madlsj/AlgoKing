package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ZCYTreeMaxWidth {
    
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //弹出才加总数！
    
    //hashMap实现
    
    public static int maxWidthUseMap(Node head){
        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null){
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel){
                curLevelNodes++;
            }else {
                //到下一层才抓
                max = Math.max(curLevelNodes, max);
                curLevel++ ;
                curLevelNodes = 1 ;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
    
    //不用map
    public static int maxWidthNoMap(Node head){
        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;//当前层，最右节点是谁
        Node nextEnd = null;//下一层，最右节点是谁
        int max = 0;
        int curLevelNdoes = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNdoes++;
            
            if (cur == curEnd){
                max = Math.max(max,curLevelNdoes);
                curLevelNdoes = 0 ;
                curEnd = nextEnd;
            }
        }
        return max;
        
    }
    
}
