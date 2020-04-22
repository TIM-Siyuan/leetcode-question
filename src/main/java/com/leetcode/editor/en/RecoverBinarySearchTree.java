//Two elements of a binary search tree (BST) are swapped by mistake. 
//
// Recover the tree without changing its structure. 
//
// Example 1: 
//
// 
//Input: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//Output: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// Example 2: 
//
// 
//Input: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//Output: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
// 
//
// Follow up: 
//
// 
// A solution using O(n) space is pretty straight forward. 
// Could you devise a constant space solution? 
// 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class RecoverBinarySearchTree{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new RecoverBinarySearchTree().new Solution();
       TreeNode head = new TreeNode(3);
       head.left = new TreeNode(1);
       head.right = new TreeNode(4);
       head.right.left = new TreeNode(2);
       solution.recoverTree(head);
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
    TreeNode prev, node1, node2;
    int count = 0;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        prev = null; node1 = null; node2 = null;
        inOrder(root);
        if(node1 != null && node2 != null)
            swap(node1, node2);
    }

    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        if(prev == null) {
            prev = node;
        }
        else{
            if(prev.val > node.val){
                if(count < 1){ //条件最好改为 node1 == null
                    node1 = prev;  //第一个逆序点 大的是
                    count++;
                }
                //此处不能加else; 因为有可能两个错误元素相邻, 判断到后一个数
                //如果加else, 则node2为空, 所以不加else, 如果不相邻则node2被更改
                //test case: [3,1,4,null,null,2] --> 1 3 2 4
                node2 = node; //第二个逆序点 小的是
            }
            prev = node;
        }
        inOrder(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}