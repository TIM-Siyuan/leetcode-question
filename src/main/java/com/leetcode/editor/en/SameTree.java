//Given two binary trees, write a function to check if they are the same or not.
// 
//
// Two binary trees are considered the same if they are structurally identical a
//nd the nodes have the same value. 
//
// Example 1: 
//
// 
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
// 
//
// Example 2: 
//
// 
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
// 
//
// Example 3: 
//
// 
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
// 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class SameTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new SameTree().new Solution();
       
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;

        boolean f1 = p.val == q.val;
        boolean f2 = isSameTree(p.left, q.left);
        boolean f3 = isSameTree(p.right, q.right);

        return f1 && f2 && f3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}