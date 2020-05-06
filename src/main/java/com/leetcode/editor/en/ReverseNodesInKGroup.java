//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class ReverseNodesInKGroup{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new ReverseNodesInKGroup().new Solution();

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        //记录虚拟头节点dummyhead; 并设置指针dummy, 使用dummy进行操作
        //保证最后可找到头节点dummyhead.next的位置
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode dummy = dummyhead;
        //记录计算k, 什么时候开始下一次翻转; 初始为0, 相当于记虚拟头节点
        int i = 0;
        while (head != null){
            //进入循环先i++; 因为从从第一个节点开始计数
            i++;
            //只有当i是k的倍数的时候, 证明此次翻转结束, 开始进行下一次翻转
            if(i % k == 0){
                //返回的是此次翻转前的链表头, 翻转后的链表尾
                dummy = reverseList(dummy, head.next);
                //将翻转后的链表尾连接在下一个节点上(即将1连接4)
                head = dummy.next;
            }
            //已经进行过翻转, 不断向下寻找end; 如果找到null还没有进行下一次翻转则退出循环
            else{
                head = head.next;
            }
        }
        return dummyhead.next;
    }

    /*
    *    k = 3; 链表从1开始翻转, 所以k=3从3开始翻转
    *    0 --> 1 --> 2 --> 3 --> 4 --> 5
    *    |     |     |     |
    *  begin  curr  next  end
    * (prev) (first)
    * (dummy) (head)
    *
    *    3 --> 2 --> 1 --> 0     4 --> 5
    *                |     |     |
    *                |   begin  end
    *   (prev)     (first)     (curr)
    *
    *    0 --> 3 --> 2 --> 1     4 --> 5
    *    |                 |     |
    *   begin              |    end
    *        (prev)     (first)(curr)
    *
    *  此时next是下一个需要被翻转的head, curr相当于dummy(prev)
    */

    // begin是此次要翻转链表的dummy, end相当于下一次要翻转链表的dummy, 所以end的指向不变
    private ListNode reverseList(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        // 需要保留dummy和head的位置, 使用指针指向他们; 如果只是反转一次链表则不需要
        ListNode prev = begin;
        ListNode first = curr;
        while (curr != end){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 翻转之后分为两步, 一是因为dummy也被翻转了, 相当于上一条被翻转的链表尾成了此条被翻转链表的链表尾
        // 所以将dummy重新移回被此条翻转链表的head, 即变回上一条被翻转链表的尾;
        // 二是dummy变为头, 被翻转前真正的链表头(1), 需要变成链表尾, 并连接下一条待翻转链表
        // 原先记录的dummy和head需要被更改为下一次反转的dummy和head
        begin.next = prev;
        // dummy为虚拟节点, head翻转后变为tail连接下一条链
        first.next = curr;
        // 返回上一条翻转链的tail当作下一条翻转链的dummy
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}