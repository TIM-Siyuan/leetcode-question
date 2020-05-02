//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If 
//pos is -1, then there is no cycle in the linked list. 
//
// Note: Do not modify the linked list. 
//
// 
//
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
//
// 
//
// Follow-up: 
//Can you solve it without using extra space? 
// Related Topics Linked List Two Pointers

//https://blog.csdn.net/willduan1/article/details/50938210

package com.leetcode.editor.en;

public class LinkedListCycleIi{
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
       Solution solution = new LinkedListCycleIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        //跳出时需要判断是否有cycle, 是break跳出还是无环跳出
        if(fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}