//Given a binary tree, return the bottom-up level order traversal of its nodes' 
//values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search


package com.leetcode.editor.en;

import javafx.util.Pair;
import java.util.*;

public class BinaryTreeLevelOrderTraversalIi{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
       
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.push(new Pair<TreeNode, Integer>(root, 0));
        if(root == null)
            return res;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> front= queue.pop();
            TreeNode node = front.getKey();

            int level = front.getValue();
            if(level == res.size()){
                res.add(new ArrayList<Integer>());
            }

            res.get(level).add(node.val);
            if(node.left != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}