//Return any binary tree that matches the given preorder and postorder traversal
//s. 
//
// Values in the traversals pre and post are distinct positive integers. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// 
//
// Note: 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] and post[] are both permutations of 1, 2, ..., pre.length. 
// It is guaranteed an answer exists. If there exists multiple answers, you can 
//return any of them. 
// 
// 
// Related Topics Tree


package com.leetcode.editor.en;

import sun.reflect.generics.tree.Tree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        node2 = node1.left; node3 = node1.right; node4 = node2.left; node5 = node2.right; node6 = node3.left; node7 = node3.right;
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2 ,6 ,7, 3, 1};
        solution.constructFromPrePost(pre, post);
    }
    // 先序后序遍历二叉树不能唯一的确定一个二叉树, 所以题目要求为Any二叉树
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
    /*
    先序遍历: 根左右;
              \
               \
    后序遍历: 左右根; 根值相同可确定子树范围(先左子树后右子树) 根据此特性, 可设定Start, End递归建树

    pre = {1, 2, 4, 5, 3, 6, 7};
    post = {4, 5, 2 ,6 ,7, 3, 1};
    先序: 1.寻找左子树根节点(2) 3.取index+1(3)长度的串(245) 4.得到左子树分割点
    后序: 2.找到对于左子树根节点 index=2
    #伪代码，用于理解思路
    def func(pre, post):   #pre为先序序列，post为后序序列
        ...
        node = Node(pre[0])
        index = find_index(post, pre[1].val)  #查找分割点下标
        node.left = func(pre[1:index+2], post[:i+1])
        node.right = func(pre[index+2:], post[i+1:-1])
        return node
    ————————————————
    https://blog.csdn.net/waple_0820/java/article/details/81837875

    提升效率: 使用Index, 数组不变, 指针移动; 使用后序限制, 隐形的确定边界而不用设定Start, End改变数组
    root.val // 当前节点, 根据先序根左右的顺序走; 取出当前节点
    post[postIndex] // 分割点; 确定边界; 后序从最左开始, 遇到了最左则开始移动;
    边界条件通过节点与割点设置, 节点与分割点不相等时,继续遍历; 相等时表明到了一个边界, 不再执行下一层的建树, 跳回上一层。
    运行过程: 先左后右再根 --> 根据后序建树
        此时分割点是左, 分割点移动到右, 跳回根返回左, 往下执行右建树;
        此时分割点是右, 分割点移动到根, 跳回根返回右, 分割点移动到下一棵树左, 再返回到更上一层根, 返回到上一层根左, 往下执行上一层根右建树
    写代码过程: 改变数组法-->根要做的就是建点, 同时分隔出边界; 用Index-->根需要建点, 同时利用类似回溯的手段设置边界(遍历到割点则退回上一层, 同时割点++)
    */
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0 || pre.length != post.length) return null;

        int rootVal = pre[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        if(root.val != post[postIndex]) root.left = constructFromPrePost(pre, post);
        if(root.val != post[postIndex]) root.right = constructFromPrePost(pre, post);

        postIndex++;
        System.out.println(root.val);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}