//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class RemoveDuplicatesFromSortedList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
       
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                cur = cur.next;
            }
            else{
                cur.next = cur.next.next;
            }
        }
        return dummyhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}