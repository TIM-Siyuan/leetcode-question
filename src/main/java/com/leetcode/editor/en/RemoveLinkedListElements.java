//Remove all elements from a linked list of integers that have value val. 
//
// Example: 
//
// 
//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class RemoveLinkedListElements{
    public static void main(String[] args) {
       Solution solution = new RemoveLinkedListElements().new Solution();
       
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
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode cur = dummyhead;
        while(cur.next != null){
            if(cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }
            else
                cur = cur.next;
        }
        return dummyhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}