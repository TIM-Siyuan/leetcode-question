//Write a program to find the node at which the intersection of two singly linke
//d lists begins. 
//
// For example, the following two linked lists: 
//
//
// begin to intersect at node c1. 
//
// 
//
// Example 1: 
//
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B. 
//
// 
//
// Example 2: 
//
//
// 
//Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
// 
//
// 
//
// Example 3: 
//
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
//
// Notes: 
//
// 
// If the two linked lists have no intersection at all, return null. 
// The linked lists must retain their original structure after the function retu
//rns. 
// You may assume there are no cycles anywhere in the entire linked structure. 
// Your code should preferably run in O(n) time and use only O(1) memory. 
// 
// Related Topics Linked List


package com.leetcode.editor.en;

public class IntersectionOfTwoLinkedLists{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public static void main(String[] args) {
       Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //法一: 两条链表长度可能相差很多, 假如有intersection的话, 说明重合的部分一定<=短链表; 所以可以先移动长链表
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Java函数是值传递, 即不改变原参数的值; 如果不这样则链表头已经被移动, 后续headA, headB已经不在链表头
        int nA = getLength(headA), nB = getLength(headB);
//        while (headA != null){
//            headA = headA.next;
//            nA++;
//        }
//        while (headB != null){
//            headB = headB.next;
//            nB++;
//        }
        if(nA > nB){
            int n = nA - nB;
            while(n > 0){
                headA = headA.next;
                n--;
            }
        }
        else {
            int n = nB - nA;
            while (n > 0){
                headB = headB.next;
                n--;
            }
        }
        //因为此时两链表长度相等, 且重合部分长度必相等, 所以不重合部分长度也相等; 所以如果不重合一起往下走
        //不会有一个节点相等, 后续又不相等的情况
        while (headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        //假如有遇到相等的点, 则链表没遍历完, 返回节点; 否则遍历完无交集返回null
        return (headA != null && headB != null) ? headA : null;
    }

    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }*/

    //https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    //法二: 利用环的思想, 因为两条链表相等时走的距离相等, ab相等时只可能为重合节点或null
    //a, b链表长度相等, 走的长度相等, 容易理解
    //a, b链表长度不相等, c为重合段; 当a, b相遇的时候, a走了a + c + b, b走了b + c + a, c段长度相等,假如不重合c = 0则返回null, 反之返回第一个重合节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}