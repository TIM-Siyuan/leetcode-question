//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics Tree Depth-first Search Breadth-first Search


package com.leetcode.editor.en;

public class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
       Solution solution = new MinimumDepthOfBinaryTree().new Solution();
       
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

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}