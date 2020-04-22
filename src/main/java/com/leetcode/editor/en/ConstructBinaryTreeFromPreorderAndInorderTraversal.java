//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


package com.leetcode.editor.en;

import sun.reflect.generics.tree.Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
       
    }
//   题解: https://www.cnblogs.com/springfor/p/3884034.html
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int rootVal = pre[preStart];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart + 1, preStart+len, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}