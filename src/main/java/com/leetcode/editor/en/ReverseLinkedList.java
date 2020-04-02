//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List


package com.leetcode.editor.en;

import com.sun.org.apache.xpath.internal.objects.XNull;

public class ReverseLinkedList{
    public static void main(String[] args) {
       Solution solution = new ReverseLinkedList().new Solution();
       
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
    /*public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }*/

    public ListNode reverseList(ListNode head) {
       /* ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;*/

        if(head == null || head.next == null)
            return head;
        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rhead;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}