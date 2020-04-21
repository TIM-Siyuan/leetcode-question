//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class ValidateBinarySearchTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new ValidateBinarySearchTree().new Solution();
       
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
//  BST需要的是子树的值全都大于或小于根节点; 所以构建辅助函数，多传入参数; 将该节点的值作为最大值传给左节点, 则左节点的右孩子也要满足小于这个max;
//  对于root的操作, 考虑只有一个点, 假设有min和max, 写出代码; 写递归的时候要认识到参数的意义, 函数传入一个节点和上层的值, 左孩子只管max值
//  min参数一直为null; 右孩子递归只管min, max一直为null, 则可判断BST;
/*      root(max)
        /
    root.left(有自身的值,也有root传下来的max值; 这层向下递归的时候, root.left.right需要跟max即上一层的root值比较,保证了小于max,不断更新最大最小值)
        \
        root.left.right(有三个值, root.left.right, root.left, root; 链式, 则不会出现只判断左右孩子，导致root.left.right比root还大的错误)
*/
    public boolean c(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}