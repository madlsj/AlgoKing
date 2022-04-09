package GreedyAndTrieTree;

import java.util.HashMap;


public class Code01_TrieTree {
    //声明变量和赋值分开
    //在无参构造器里面赋值
    //结点为路径服务！仅仅占位保存信息。
    public static class Node1{
        public int pass;
        public int end;
        public HashMap<Integer,Node1> nexts;
        
        public Node1(){
            pass = 0 ;
            end = 0;
            nexts = null;
        }
    }
    
    public static class Trie2{
        private Node1 root;
        public Trie2(){
            root = new Node1();
        }
        
        public void insert(String word){
            if (word ==null){
                return;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0 ; i< chars.length;i++){
                index = (int)chars[i];
                if (!node.nexts.containsKey(index)){
                    node.nexts.put(index,new Node1());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public boolean search(String word) {
            if (word==null){
                return false;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i =  0; i< chars.length;i++){
                index = (int)chars[i];
                if(!node.nexts.containsKey(index)){
                    return false;
                }
                node = node.nexts.get(index);
            }
            return true;

        }

        public boolean startsWith(String prefix) {
            if(prefix == null){
                return false;
            }
            char [] chars = prefix.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0 ; i< chars.length;i++){
                index = (int)chars[i];
                if(!node.nexts.containsKey(index)){
                    return false;
                }
                node = node.nexts.get(index);
            }
            return true;
        }
         
        
        
        
    }
    
}
