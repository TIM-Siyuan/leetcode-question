//Given a root node reference of a BST and a key, delete the node with the given
// key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages:
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
// 
//
// Note: Time complexity should be O(height of tree). 
//
// Example:
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Given key to delete is 3. So we find the node with value 3 and delete it.
//
//One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//Another valid answer is [5,2,6,null,4,null,7].
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics Tree


package com.leetcode.editor.en;

public class DeleteNodeInABst{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       Solution solution = new DeleteNodeInABst().new Solution();
       
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            if(root.left != null && root.right != null){
                TreeNode minNode = getMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{ //root.val < key
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    //递归
    private TreeNode getMin(TreeNode node){
        if(node.left == null) return node;
        return getMin(node.left);
    }

    /*private TreeNode getMin(TreeNode node){
        if(node == null) return null;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}