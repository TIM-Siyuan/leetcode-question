//
//Given a binary tree, you need to compute the length of the diameter of the tre
//e. The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
// 
//
// 
//Example: 
//Given a binary tree 
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
// 
// 
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Note:
//The length of path between two nodes is represented by the number of edges bet
//ween them.
// Related Topics Tree


package com.leetcode.editor.en;

import java.util.HashMap;
import java.util.Stack;

public class DiameterOfBinaryTree{
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
       Solution solution = new DiameterOfBinaryTree().new Solution();
       
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
    //递归
    /*private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root, res);
        return res;
    }

    private int maxDepth(TreeNode root, int res){
        if(root == null) return 0;

        int left = maxDepth(root.left, res);
        int right = maxDepth(root.right, res);

        res = Math.max(res, left + right);
        int Depth = Math.max(left, right) + 1;

        return Depth;
    }*/

    //迭代
    public int diameterOfBinaryTree(TreeNode root){
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> stack = new Stack<>();
        int res = 0;

        if(root != null) stack.push(root);

        //后序遍历, 左右根
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null && !map.containsKey(node.left)) //相当于递归到左底
                stack.push(node.left);
            else if(node.right != null && !map.containsKey(node.right)) //当左底被pop()之后, 会返回node, 再计算其右(如果存在)
                stack.push(node.right);
            else{
                //计算node的深度, 所以此节点可以被pop()
                stack.pop();
                //node左右节点初始化存入map
                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);
                map.put(node, 1 + Math.max(left, right));

                res = Math.max(res, left + right);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}