//Sort a linked list in O(n log n) time using constant space complexity. 
//
// Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5 
// Related Topics Linked List Sort


package com.leetcode.editor.en;

import java.util.LinkedList;

public class SortList{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new SortList().new Solution();
       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       node1.next = node2; node2.next = node3; node3.next = node4;
       solution.sortList(node1);
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
    //递归实现merge
   /* public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }*/

    /*public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return dummy.next;
    }*/

    //递归实现merge
    /*private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }*/

    //迭代实现merge: Bottom to Up 空间复杂度: O(1)
    public ListNode sortList(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //得到链表的长度
        int n = 0;
        while (head != null){
            head = head.next;
            n++;
        }

        for(int step = 1; step < n; step <<= 1){
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null){
                //形成两个归并区间
                ListNode left = cur;
                ListNode right = split(left, step);
                //cur是下一个归并区间的头
                cur = split(right, step);
                //合并两个区间
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int step){
        if(head == null) return null;
        for(int i = 1; head.next != null && i < step; i++){
            head = head.next;
        }
        //此时的head已经是区间尾, 按step分隔开; 返回下一个区间的头(即head.next), 并断开两个区间联系, head.next = null;
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev){
        //新建的合并链
        ListNode cur = prev;
        while (left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) cur.next = left;
        if (right != null) cur.next = right;
        //返回合并链的链尾, 所以要移动到链尾; 递归时只需要返回链头, 所以没有这步
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}