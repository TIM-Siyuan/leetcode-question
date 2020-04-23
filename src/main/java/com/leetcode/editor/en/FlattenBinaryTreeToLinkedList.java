//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class FlattenBinaryTreeToLinkedList{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
       
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
    //题意的顺序是先序遍历, 参考DFS先找到最左端的节点(所以是自底向上递归)
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        flatten(root.left);
        flatten(root.right);
        TreeNode p = root.right; //1. 记录root.right
        root.right = root.left; // 2. 左子树移动到右子树
        root.left = null;       // 3. 左子树赋为空
        while(root.right != null){ // 4. 找到最右节点
            root = root.right;
        }
        root.right = p; //5. 将之前脱离的右子树接上
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}