//Given a binary tree containing digits from 0-9 only, each root-to-leaf path co
//uld represent a number. 
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123. 
//
//
// Find the total sum of all root-to-leaf numbers. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25. 
//
// Example 2: 
//
// 
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026. 
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

public class SumRootToLeafNumbers{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new SumRootToLeafNumbers().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);

        TreeNode node3 = new TreeNode(9);
        node3.left = node1;
        node3.right = node2;

        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        node5.right = node4;
        node5.left = node3;

        solution.sumNumbers(node5);

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
   /* public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
*/
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int level){
        //终止条件
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val + level;
        //升一个level*10
        int nextLevel = (level + root.val) * 10;
        //left+right 返回左右子树的和
        int leftSum = sumNumbers(root.left, nextLevel);
        int rightSum = sumNumbers(root.right, nextLevel);

        return leftSum + rightSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}