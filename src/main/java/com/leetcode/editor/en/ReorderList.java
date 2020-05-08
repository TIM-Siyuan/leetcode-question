//Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// Example 1: 
//
// 
//Given 1->2->3->4, reorder it to 1->4->2->3. 
//
// Example 2: 
//
// 
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class ReorderList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
       Solution solution = new ReorderList().new Solution();
       
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //寻找中点
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //翻转后半部分链表
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //合并
        ListNode cur = head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = cur;
        dummy2.next = prev;
        //取中点时后半部分的节点数小于等于前半部分, 所以只要考虑prev即可
        while(prev != null){
            //保存两条链当前节点的下一节点, 因为重新合并时会失去与下一节点的联系
            ListNode node1 = cur.next;
            ListNode node2 = prev.next;
            //将两条链表进行重新连接
            cur.next = prev;
            prev.next = node1;
            //移动prev, cur;
            prev = node2;
            cur = node1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}