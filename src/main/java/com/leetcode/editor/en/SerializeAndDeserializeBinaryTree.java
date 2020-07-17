//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a bina
//ry tree. You do not necessarily need to follow this format, so please be creativ
//e and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree Design


package com.leetcode.editor.en;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
//       Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
       
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
public class Codec {

    // Encodes a tree to a single string.
/*    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        return sb.toString();
    }

    private void helperS(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(",");
        helperS(node.left, sb);
        helperS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split("[,]");
        int[] index = new int[]{0};
        return helperD(vals, index);
    }

    private TreeNode helperD(String[] vals, int[] index){
        if(index[0] == vals.length) return null;

        String visiting = vals[index[0]++];
        if(visiting.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(visiting));
        node.left = helperD(vals, index);
        node.right = helperD(vals, index);

        return node;
    }*/

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        return sb.toString();
    }

    private void helperS(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(",");
        helperS(node.left, sb);
        helperS(node.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] strArr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strArr);
        return helperD(queue);
    }

    private TreeNode helperD(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String s = queue.poll();
        if(s.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helperD(queue);
        root.right = helperD(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}