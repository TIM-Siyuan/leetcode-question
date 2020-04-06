//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics Linked List Two Pointers


package com.leetcode.editor.en;

public class PalindromeLinkedList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new PalindromeLinkedList().new Solution();
    }
//    https://www.jianshu.com/p/593855d32fe5 快慢指针找中点
//    https://blog.csdn.net/sunao2002002/article/details/46918645
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse List
        //不管是偶数链还是奇数链，找到中间指针之后，反转应该从slow.next开始；
        //否则下面从head对比时，head少一个数据，Nullpointer;
        slow = ReverseLinkedList(slow.next);

        while(slow != null){
            if(head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode ReverseLinkedList(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}