//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Follow up: 
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
// 
//
// 
//Example:
// 
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
// 
// Related Topics Linked List


package com.leetcode.editor.en;

import java.util.Stack;

public class AddTwoNumbersIi{
    public static void main(String[] args) {
       Solution solution = new AddTwoNumbersIi().new Solution();

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
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = dummyhead;
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        while(!stack1.isEmpty()){
            int num1 = stack1.pop();
            int sum = num1 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        while(!stack2.isEmpty()){
            int num2 = stack2.pop();
            int sum = num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }

//      反转链表
        ListNode pre = null;
        ListNode head = dummyhead.next;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

//    简洁版本
/*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> l1stack = new Stack<>();
    Stack<Integer> l2stack = new Stack<>();

    ListNode ltemp1 = l1;
    while(l1 != null){
        l1stack.push(l1.val);
        l1 = l1.next;
    }
    ListNode ltemp2 = l2;
    while(l2 != null){
        l2stack.push(l2.val);
        l2 = l2.next;
    }

    ListNode curr = null;
    int carry = 0;
    while(!l1stack.isEmpty() || !l2stack.isEmpty()){
        int l1val = (l1stack.isEmpty())? 0: l1stack.pop();  巧妙！！！
        int l2val = (l2stack.isEmpty())? 0: l2stack.pop();

        int sum = carry + l1val + l2val;
        carry = sum / 10;
        sum = sum % 10;

        ListNode temp = new ListNode(sum);
        temp.next = curr;
        curr = temp;

    }

    if(carry > 0) {
        ListNode temp = new ListNode(carry);
        temp.next = curr;
        curr = temp;
    }
    return curr;
}*/
}
//leetcode submit region end(Prohibit modification and deletion)


}