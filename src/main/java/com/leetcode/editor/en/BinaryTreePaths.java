//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths{
    public static void main(String[] args) {
       Solution solution = new BinaryTreePaths().new Solution();
       
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        for(String s : leftPaths){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> rightPaths  = binaryTreePaths(root.right);
        for(String s : rightPaths){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}