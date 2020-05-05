//Reverse a linked list from position m to n. Do it in one-pass. 
//
// Note: 1 ≤ m ≤ n ≤ length of list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class ReverseLinkedListIi{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
       Solution solution = new ReverseLinkedListIi().new Solution();
       
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
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int k) {
        if(k == 1){
            successor = head.next;
            return head;
        }
        ListNode rhead = reverseN(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return rhead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}