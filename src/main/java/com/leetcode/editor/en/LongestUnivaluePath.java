//Given a binary tree, find the length of the longest path where each node in th
//e path has the same value. This path may or may not pass through the root. 
//
// The length of path between two nodes is represented by the number of edges be
//tween them. 
//
// 
//
// Example 1: 
//
// Input: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// Output: 2 
//
// 
//
// Example 2: 
//
// Input: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// Output: 2 
//
// 
//
// Note: The given binary tree has not more than 10000 nodes. The height of the 
//tree is not more than 1000. 
// Related Topics Tree Recursion


package com.leetcode.editor.en;

import java.util.Arrays;

public class LongestUnivaluePath{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
        }
    }
    public static void main(String[] args) {
       Solution solution = new LongestUnivaluePath().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //helper: 递归计算左右子树的路径能否增加, 左右子树的节点值并与parent值对比, 假如节点值相等, 则返回值+1, 反之返回0; 则结果也可能更长;
    //最长的路径(可能为左右子树相加) 存在res中, 但是这并不是递归的返回值; 因为有可能某节点值为1的其下最长路径为3; 但是其上层有节点值为2的路径为5; 自底向上更容易考虑
    //原因: 因为不一定过根节点, 所以最长路径的是哪个节点值不确定, 递归求的是相同节点值的最长路径, 不同节点值重新计算长度, 所以res更新结果, 不作为返回值;
    /*public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        Arrays.fill(res, 0);
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        left = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
        right = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }*/

    //法二
    /*public int longestUnivaluePath(TreeNode root){
        if(root == null) return 0;
        int[] res = new int[1];
        Arrays.fill(res, 0);
        helper(root, root.val, res);
        return res[0];
    }

    private int helper(TreeNode root, int parent, int[] res){
        if(root == null) return 0;
        int left = helper(root.left, root.val, res);
        int right = helper(root.right, root.val, res);
        res[0] = Math.max(res[0], left + right);
        if(root.val == parent) return 1 + Math.max(left, right);
        else return 0;
    }*/

    //法三: 没有res,
    public int longestUnivaluePath(TreeNode root){
        if(root == null) return 0;
        //helper是跟parent节点值相同才会返回数值, 否则返回0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        //返回左右子树中最长路径(节点值不确定)
        int sub = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        //sub: 除去根节点外, 左右子树中的最大结果; left+right: 根节点的最大结果, 因为跟parent节点值相同才可能大于sub, 否则left+right == 0;
        return Math.max(sub, left + right);
    }

    //helper返回路径最大值, 如果节点值跟parent相同才返回, 否则返回0
    private int helper(TreeNode root, int parent){
        if(root == null || root.val != parent) return 0;
        return 1 + Math.max(helper(root.left, root.val), helper(root.right, root.val));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}