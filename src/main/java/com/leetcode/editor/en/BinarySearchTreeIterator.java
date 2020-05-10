//Implement an iterator over a binary search tree (BST). Your iterator will be i
//nitialized with the root node of a BST. 
//
// Calling next() will return the next smallest number in the BST. 
//
// 
//
// 
// 
//
// Example: 
//
// 
//
// 
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
// 
//
// 
//
// Note: 
//
// 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, wh
//ere h is the height of the tree. 
// You may assume that next() call will always be valid, that is, there will be 
//at least a next smallest number in the BST when next() is called. 
// 
// Related Topics Stack Tree Design


package com.leetcode.editor.en;

import java.util.Stack;

public class BinarySearchTreeIterator{
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
       Solution solution = new BinarySearchTreeIterator().new Solution();
       
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
class BSTIterator {
    Stack<TreeNode> stk = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while (root != null){
            stk.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stk.pop();
        int res = node.val;
        if(node.right != null){
            //如果这里新建另一个TreeNode指向node.right; 最后返回时需要返回node.val, 指针无val会报空指针错误
            node = node.right;
            while (node != null){
                stk.push(node);
                node = node.left;
            }
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)


}