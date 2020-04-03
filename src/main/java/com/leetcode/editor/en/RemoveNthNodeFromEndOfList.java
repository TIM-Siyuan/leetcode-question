//Given a linked list, remove the n-th node from the end of list and return its 
//head. 
//
// Example: 
//
// 
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
// 
//
// Note: 
//
// Given n will always be valid. 
//
// Follow up: 
//
// Could you do this in one pass? 
// Related Topics Linked List Two Pointers


package com.leetcode.editor.en;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
       
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert(n>=0);
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode p = dummyhead;
        ListNode q = dummyhead;
        for(int i = 0; i < n+1; i++){
            assert(q != null);
            q = q.next;
        }
        while(q != null){
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;

        return dummyhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}