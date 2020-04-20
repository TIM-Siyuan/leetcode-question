//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new PathSumIi().new Solution();
       
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
   /* public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        findPathSum(root, sum, new ArrayList<Integer>(), res);

        return res;
    }

    private void findPathSum(TreeNode node, int num, ArrayList<Integer> list, ArrayList<List<Integer>> res){
        if(node == null) return;

        if(node.left == null && node.right == null && node.val == num){
            list.add(node.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        if(node.left != null) findPathSum(node.left, num - node.val, list, res);
        if(node.right != null) findPathSum(node.right, num - node.val, list, res);
        list.remove(list.size() - 1);
        return;
    }*/

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();

        findPathSum(root, sum, list, res);

        return res;
    }

    private void findPathSum(TreeNode node, int num, LinkedList<Integer> list, ArrayList<List<Integer>> res){
        if(node == null) return;

        list.addLast(node.val);
        if(node.left == null && node.right == null && node.val == num){
            res.add(new ArrayList<>(list));
        }

        findPathSum(node.left, num - node.val, list, res);
        findPathSum(node.right, num - node.val, list, res);

        list.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}