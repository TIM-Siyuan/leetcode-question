//Given the root node of a binary search tree, return the sum of values of all n
//odes with value between L and R (inclusive). 
//
// The binary search tree is guaranteed to have unique values. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32
// 
//
// 
// Example 2: 
//
// 
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is at most 10000. 
// The final answer is guaranteed to be less than 2^31. 
// 
// 
// Related Topics Tree Recursion


package com.leetcode.editor.en;

import java.util.Stack;

public class RangeSumOfBst{
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
       Solution solution = new RangeSumOfBst().new Solution();
       
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
    //法一: DFS整棵树, 但是记录结果时判断大小
    /*private int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;

        rangeSumBST(root.left, L, R);
        if(L <= root.val && root.val <= R) res += root.val;
        rangeSumBST(root.right, L, R);

        return res;
    }*/

    /*public int rangeSumBST(TreeNode root, int L, int R){
        if(root == null) return 0;
        //遍历完全再判断
        return (L <= root.val && root.val <= R ? root.val : 0) + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }*/

    /*public int rangeSumBST(TreeNode root, int L, int R){
        if(root == null) return 0;
        int sum = 0;
        if(root.val > L) sum += rangeSumBST(root.left, L, R);
        if(root.val < R) sum += rangeSumBST(root.right, L, R);
        if(root.val >= L && root.val <= R) sum += root.val;
        return sum;
    }*/

    //法二: 遍历时则判断, 不需要遍历完整棵树 --> 效率最高
    /*public int rangeSumBST(TreeNode root, int L, int R){
        if(root == null) return 0;
        if(root.val < L) return rangeSumBST(root.right, L, R); //比L还小就找右孩子
        if(root.val > R) return rangeSumBST(root.left, L, R); //比R还大找左孩子
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); //最后能返回的都是L <= node.val <= R的
    }*/

    //法三: 迭代 --> 与法二类似, 空间复杂度最低
    /*public int rangeSumBST(TreeNode root, int L, int R){
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int sum = 0;
        while (!stk.isEmpty()){
            TreeNode n = stk.pop();
            if(n == null) continue;
            if(n.val < R) stk.push(n.right);
            if(n.val > L) stk.push(n.left);
            if(L <= n.val && n.val <= R) sum += n.val;
        }
        return sum;
    }*/
}

//leetcode submit region end(Prohibit modification and deletion)

}