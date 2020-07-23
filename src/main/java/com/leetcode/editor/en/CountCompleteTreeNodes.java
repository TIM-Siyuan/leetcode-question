//Given a complete binary tree, count the number of nodes. 
//
// Note: 
//
// Definition of a complete binary tree from Wikipedia: 
//In a complete binary tree every level, except possibly the last, is completely
// filled, and all nodes in the last level are as far left as possible. It can hav
//e between 1 and 2h nodes inclusive at the last level h. 
//
// Example: 
//
// 
//Input: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//Output: 6 
// Related Topics Binary Search Tree


package com.leetcode.editor.en;

public class CountCompleteTreeNodes{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new CountCompleteTreeNodes().new Solution();
       
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
    //递归
    /*public int countNodes(TreeNode root) {
        return root == null ? (1 + countNodes(root.left) + countNodes(root.right)) : 0;
    }*/

    int height(TreeNode root){
       return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root){
        int res = 0, h = height(root);
        while (root != null){
            if(height(root.right) == h - 1){
                res += 1 << h;
                root = root.right;
            } else {
                res += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}