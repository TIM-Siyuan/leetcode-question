//Given a binary search tree, return a balanced binary search tree with the same
// node values. 
//
// A binary search tree is balanced if and only if the depth of the two subtrees
// of every node never differ by more than 1. 
//
// If there is more than one answer, return any of them. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,2,null,3,null,4,null,null]
//Output: [2,1,3,null,null,null,4]
//Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is 
//also correct.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is between 1 and 10^4. 
// The tree nodes will have distinct values between 1 and 10^5. 
// Related Topics Binary Search Tree


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;

public class BalanceABinarySearchTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
       Solution solution = new BalanceABinarySearchTree().new Solution();
       
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
    //中序遍历 + LC108建树 -> 用ArrayList 3ms 43.2MB/ LinkedList 438ms 42.6MB
    /*public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<>();
        inOrder(root, vals);
        return buildTree(vals, 0, vals.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> vals, int l, int r){
        if(l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(vals.get(m));
        root.left = buildTree(vals, l, m - 1);
        root.right = buildTree(vals, m + 1, r);
        return root;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> vals){
        if(node == null) return;
        inOrder(node.left, vals);
        vals.add(node.val);
        inOrder(node.right, vals);
    }*/

    //follow up: ArrayList<TreeNode> 这样无需新建TreeNode, 节省空间 2ms 42.4MB
    /*ArrayList<TreeNode> vals = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildTree(0, vals.size() - 1);
    }

    private TreeNode buildTree(int l, int r){
        if(l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode root = vals.get(m);
        root.left = buildTree(l, m - 1);
        root.right = buildTree(m + 1, r);
        return root;
    }

    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        vals.add(node);
        inOrder(node.right);
    }*/

    //DSW Day-Stout-Warren algorithm time:O(n) space:O(1), 无需额外空间
    //右旋形成主链 -> 左旋转换为平衡树; 此题中已经形成主链, 只需要不断左旋(偶数节点围绕奇数点转)
    private int makeVine(TreeNode root){
        int cnt = 0; //需要计算主链长度
        TreeNode node = root.right;
        while (node != null){
            if(node.left != null){
                TreeNode old_node = node;
                node = node.left;
                old_node.left = node.right;
                node.right = old_node;
                root.right = node;
            }
            else{
                ++cnt;
                root = node;
                node = node.right;
            }
        }
        return cnt;
    }

    private void compress(TreeNode root, int m){
        TreeNode node = root.right;
        while (m > 0){
            TreeNode old_node = node;
            node = node.right;
            root.right = node;
            old_node.right = node.left;
            node.left = old_node;
            root = node;
            node = node.right;
            m--;
        }
    }

    public TreeNode balanceBST(TreeNode root){
        TreeNode node = new TreeNode(0);
        node.right = root;
        int cnt = makeVine(node);
        int m = (int)Math.pow(2, (int)(Math.log(cnt + 1) / Math.log(2))) - 1;
        compress(node, cnt - m);
        for(m = m / 2; m > 0; m /= 2)
            compress(node, m);
        return node.right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}