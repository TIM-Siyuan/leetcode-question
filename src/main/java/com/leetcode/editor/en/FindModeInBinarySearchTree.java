//Given a binary search tree (BST) with duplicates, find all the mode(s) (the mo
//st frequently occurred element) in the given BST. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// For example: 
//Given BST [1,null,2,2], 
//
// 
//   1
//    \
//     2
//    /
//   2
// 
//
// 
//
// return [2]. 
//
// Note: If a tree has more than one mode, you can return them in any order. 
//
// Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count). 
// Related Topics Tree


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FindModeInBinarySearchTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new FindModeInBinarySearchTree().new Solution();
       
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
//    法一: 利用Hashmap记录所有数值和次数, 遍历计算得众数
    /*private HashMap<Integer, Integer> map;
    private int count = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        map = new HashMap<Integer, Integer>();
        inOrder(root);
        for(int key : map.keySet()){
            if(map.get(key) == count){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        count = Math.max(count, map.get(node.val));
        inOrder(node.right);
    }*/

//  法二: BST中序遍历是顺序排列的, 所以记录前一个节点，判断是否相等，记录次数
    Integer pre = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];

        ArrayList<Integer> list = new ArrayList<>();

        inOrder(root, list); //遍历要在创建数组之前，不然list为空
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> list){
        if(node == null) return;

        inOrder(node.left, list);

        if(pre != null){
            if(pre == node.val) count++;
            else count = 1;
        }

        if(count > max){
            list.clear();
            list.add(node.val);
            max = count;
        }else if(count == max){
            list.add(node.val);
        }

        pre = node.val;

        inOrder(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}