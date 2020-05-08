//Given a singly linked list, group all odd nodes together followed by the even 
//nodes. Please note here we are talking about the node number and not the value i
//n the nodes. 
//
// You should try to do it in place. The program should run in O(1) space comple
//xity and O(nodes) time complexity. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 1->3->5->2->4->NULL
// 
//
// Example 2: 
//
// 
//Input: 2->1->3->5->6->4->7->NULL
//Output: 2->3->6->7->1->5->4->NULL
// 
//
// Note: 
//
// 
// The relative order inside both the even and odd groups should remain as it wa
//s in the input. 
// The first node is considered odd, the second node even and so on ... 
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class OddEvenLinkedList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new OddEvenLinkedList().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        ListNode odd = pre;
        ListNode even = cur;
        //考虑最后只剩两个数的情况, 假如是(pre != null && cur != null) 则当pre = pre.next 为null时, cur.next = pre.next空指针错
        //即pre.next 和 cur.next 都不能为空, 假如其中一方为空仍然进入循环, 则另一方为null.next; 报空指针错误
        while(pre.next != null && cur.next != null){
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            cur = cur.next;
        }
        pre.next = even;
        return odd;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}