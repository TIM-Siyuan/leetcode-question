//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


package com.leetcode.editor.en;

import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;

public class LruCache{
    public static void main(String[] args) {
//       Solution solution = new LruCache().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/*class LRUCache {
    class Node{
        public int key, val;
        public Node prev, next;
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    //为什么要使用双向链表而不是单向链表: 因为删除操作需要得到前驱节点指针
    class DoubleList{
        private Node head;
        private Node tail;
        private int size;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            head.prev = null;
            tail.next = null;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node n){
            n.next = head.next;
            head.next.prev = n;
            n.prev = head;
            head.next = n;
            size++;
        }

        public void remove(Node n){
            if(n.prev != null)
                n.prev.next = n.next;
            else
                head = n.next;
            if(n.next != null)
                n.next.prev = n.prev;
            else
                tail = n.prev;
            size--;
        }

        public Node removeLast(){
            Node res = tail.prev;
            remove(res);
            return res;
            //初始化了head,tail都为虚拟节点, 所以更新的时候tail.prev才是tail
            *//*Node n = tail.prev;
            if(head.next == null){
                tail = null;
                head = null;
            }
            else {
                tail.prev.next = null;
            }
            tail = tail.prev;
            size--;
            return n;*//*
        }

        public int size(){
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        }
        else{
            if(cap == cache.size()){
                //虽然HashMap有key, 但是链表中需要同时存储 key 和 val，而不是只存储 val
                //因为map中需要将映射到该节点的key同时删除
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}*/

class LRUCache {
    private int capacity;
    private final HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        setHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            n.val = value;
            setHead(n);
        }
        else {
            Node created = new Node(key, value);
            if(map.size() == capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(created);
            }
            else {
                setHead(created);
            }
            map.put(key, created);
        }

    }

    private void remove(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        else {
            tail = node.prev;
        }
    }

    private void setHead(Node node){
        node.next = head;
        node.prev = null;
        if(head != null) head.prev = node;
        head = node;
        if(tail == null) tail = head;
    }

    class Node{
        public int key, val;
        public Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}