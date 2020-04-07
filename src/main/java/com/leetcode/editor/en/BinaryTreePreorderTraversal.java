//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree


package com.leetcode.editor.en;

import java.util.*;

public class BinaryTreePreorderTraversal{
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public static void main(String[] args) {
       Solution solution = new BinaryTreePreorderTraversal().new Solution();
       TreeNode head = new TreeNode(1);
       head.left = null;
       head.right = new TreeNode(2);
       head.right.left = new TreeNode(3);
       head.right.right = null;
       solution.preorderTraversal(head);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        //一开始时stack为空，所以判断条件node不为空；中间过程只要stack不为空则可；结束时stack为空；
        //先前已经判断了root不为空，但是不可以先压入node，因为while循环时会压入root，这样则压入两次root；；
        while(!stack.isEmpty() || node != null){
            if(node == null){
                node = stack.pop();
                node = node.right;
            }
            else{
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}