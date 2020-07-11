//Print a binary tree in an m*n 2D string array following these rules: 
//
// 
// The row number m should be equal to the height of the given binary tree. 
// The column number n should always be an odd number. 
// The root node's value (in string format) should be put in the exactly middle 
//of the first row it can be put. The column and the row where the root node belon
//gs will separate the rest space into two parts (left-bottom part and right-botto
//m part). You should print the left subtree in the left-bottom part and print the
// right subtree in the right-bottom part. The left-bottom part and the right-bott
//om part should have the same size. Even if one subtree is none while the other i
//s not, you don't need to print anything for the none subtree but still need to l
//eave the space as large as that for the other subtree. However, if two subtrees 
//are none, then you don't need to leave space for both of them. 
// Each unused space should contain an empty string "". 
// Print the subtrees following the same rules. 
// 
//
// Example 1: 
// 
//Input:
//     1
//    /
//   2
//Output:
//[["", "1", ""],
// ["2", "", ""]]
// 
// 
//
//
// Example 2: 
// 
//Input:
//     1
//    / \
//   2   3
//    \
//     4
//Output:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
// 
//
// Example 3: 
// 
//Input:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//Output:
//
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
// 
//
// Note:
//The height of binary tree is in the range of [1, 10].
// Related Topics Tree 
// 👍 335 👎 804


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree{
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
       Solution solution = new PrintBinaryTree().new Solution();
       
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
    /*public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, colums = (int)(Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for(int i = 0; i < colums; i++){
            row.add("");
        }
        for(int i = 0; i < rows; i++){
            res.add(new ArrayList<>(row));
        }
        helper(root, res, 0, rows, 0, colums - 1);
        return res;
    }

    private void helper(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j){
        if(row == totalRows || root == null) return;
        res.get(row).set((i + j) / 2, Integer.toString(root.val));
        helper(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        helper(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }*/

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int rows = getHeight(root);
        int cols = (int)Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[] { 0, cols - 1 });
        int row = -1;
        while (!queue.isEmpty()) {
            row++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int[] indices = indexQ.poll();

                if (cur == null) {
                    continue;
                }

                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                res.get(row).set(mid, String.valueOf(cur.val));

                queue.offer(cur.left);
                queue.offer(cur.right);
                indexQ.offer(new int[] { left, mid - 1 });
                indexQ.offer(new int[] { mid + 1, right });
            }
        }

        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}