//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap


package com.leetcode.editor.en;

public class MergeKSortedLists{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new MergeKSortedLists().new Solution();
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
    /*public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int n = lists.length;
        while (n > 1){
            //当n为奇数的时候, 确保i+k能从后半段开始, 剩下最中间的
            //当n为偶数的时候, 因为向下取整, 所以不影响
            int k = (n + 1) / 2;
            for(int i = 0; i < n / 2; i++){
                lists[i] = merge(lists[i], lists[i + k]);
            }
            //不断缩小范围
            n = k;
        }
        return lists[0];
    }*/

    //法二: 利用递归 + 分治的思路
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end){
        if(start > end) return null;
        //此步才真正对lists进行操作, 找到链表节点, 然后向上归并
        if(start == end) return lists[start];
        int mid = (start + end) >> 1;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}