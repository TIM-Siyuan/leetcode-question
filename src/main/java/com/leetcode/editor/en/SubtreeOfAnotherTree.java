//Given two non-empty binary trees s and t, check whether tree t has exactly the
// same structure and node values with a subtree of s. A subtree of s is a tree co
//nsists of a node in s and all of this node's descendants. The tree s could also 
//be considered as a subtree of itself. 
//
// Example 1: 
//Given tree s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//Given tree t:
//
// 
//   4 
//  / \
// 1   2
// 
//Return true, because t has the same structure and node values with a subtree o
//f s.
//
// 
//
// Example 2: 
//Given tree s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//Given tree t:
//
// 
//   4
//  / \
// 1   2
// 
//Return false.
//
// 
// Related Topics Tree


package com.leetcode.editor.en;

import java.util.TreeMap;

public class SubtreeOfAnotherTree{
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
       Solution solution = new SubtreeOfAnotherTree().new Solution();
       
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
    //isSameTree: 递归
    /*public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        if(isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)


}