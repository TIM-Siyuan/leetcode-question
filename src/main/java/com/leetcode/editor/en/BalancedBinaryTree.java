//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
//
// Example 1: 
//
// Given the following tree [3,9,20,null,null,15,7]: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// Return true. 
// 
//Example 2: 
//
// Given the following tree [1,2,2,3,3,null,null,4,4]: 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// Return false. 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class BalancedBinaryTree{
    public static void main(String[] args) {
       Solution solution = new BalancedBinaryTree().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int factor = Math.abs(MaxDepth(root.left) - MaxDepth(root.right));
        return factor < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int MaxDepth(TreeNode root){
        if(root == null) return 0;

        return Math.max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}