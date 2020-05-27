//Given a singly linked list where elements are sorted in ascending order, conve
//rt it to a height balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// Example: 
//
// 
//Given the sorted linked list: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following he
//ight balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics Linked List Depth-first Search


package com.leetcode.editor.en;

public class ConvertSortedListToBinarySearchTree{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
       
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归1
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode fast = head, slow = head, last = slow;
        //只剩两个节点的时候, 此写法中点在右; fast.next / fast.next.next 中点在左
        while (fast != null && fast.next != null){
            //last比slow慢一步, 所以退出循环时last在中点前一位
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链2头
        fast = slow.next;
        //链1尾
        last.next = null;
        TreeNode cur = new TreeNode(slow.val);
        if(head != slow)
            cur.left = sortedListToBST(head);
        cur.right = sortedListToBST(fast);
        return cur;
    }
    //递归2 -> 快慢指针获取中点
    /*public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        //获取中点
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);

        return root;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)


}