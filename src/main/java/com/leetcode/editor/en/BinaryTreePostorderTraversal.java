//Given a binary tree, return the postorder traversal of its nodes' values. 
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
//Output: [3,2,1]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree


package com.leetcode.editor.en;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal{
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public static void main(String[] args) {
       Solution solution = new BinaryTreePostorderTraversal().new Solution();
        TreeNode head = new TreeNode(1);
        head.left = null;
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);
        head.right.right = null;
        solution.postorderTraversal(head);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> integerStack = new Stack<Integer>();
        if(root == null)
            return res;
        // 0: go; 1:print
        integerStack.push(0);
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            int command = integerStack.pop();
            if(command == 1){
                node = stack.pop();
                res.add(node.val);
            }
            else {
                assert(command == 0);
                integerStack.push(1);
                if(node.right != null)
                    stack.push(node.right);
                    integerStack.push(0);
                if(node.left != null)
                    stack.push(node.left);
                    integerStack.push(0);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}