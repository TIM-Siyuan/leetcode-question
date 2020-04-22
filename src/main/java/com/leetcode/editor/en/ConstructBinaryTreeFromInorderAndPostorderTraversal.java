//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search


package com.leetcode.editor.en;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
       
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
    // 设置辅助函数, 设置inorder的start, end决定递归终止条件; 根据post的特性, 从后往前先全部是右子树, 后为左子树
    // 所以设置全局变量postIndex, 只需要--操作即可, 减少了postOrder的start、end两个参数
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length != inorder.length) return null;
        postIndex = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] post, int start, int end, HashMap<Integer, Integer> map){
        if(start > end) return null;
        int rootVal = post[postIndex--];
        int Index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = buildTree(post, Index + 1, end, map);
        root.left = buildTree(post, start, Index - 1, map);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}