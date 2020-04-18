//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
//
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class PathSum{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new PathSum().new Solution();
       TreeNode root = new TreeNode();
       solution.hasPathSum(root, 0);
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

    public boolean hasPathSum(TreeNode root, int sum) {
        //此处不能return sum==0;
        //因为root为空的话sum不为0; 且不存在的节点也给赋了0值，相当于凭空多了一条路;
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}