//Given a linked list, rotate the list to the right by k places, where k is non-
//negative. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
// 
//
// Example 2: 
//
// 
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL 
// Related Topics Linked List Two Pointers


package com.leetcode.editor.en;

public class RotateList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
       Solution solution = new RotateList().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode fast = head, slow = head;
        //获得链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            n++;
        }
        //法一: k相当于从尾部向前找,在k步处旋转; 但是尾部指针没法逆着走, 所以使用快慢指针, 快指针和慢指针先拉开k距离，当快指针到尾部时, 慢指针就在尾部向前数k处
        //fast先走k步, 然后slow和fast同时走, 当fast走到尾部时(fast.next == null时), slow的位置即为需要旋转的位置, slow.next为头节点
        //法二: 使用一个指针, 走(n - k % n)步, 后续操作同上
        //假如k比n大很多, fast先走k步会超出链表长度, 所以取余数即可知道移动几步且k <= n
        k %= n;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //将链表头尾相连
        fast.next = head;
        //slow.next为头节点
        fast = slow.next;
        //断开循环链
        slow.next = null;
        //返回头部
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}