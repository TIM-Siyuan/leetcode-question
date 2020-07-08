//Given a n * n matrix grid of 0's and 1's only. We want to represent the grid w
//ith a Quad-Tree. 
//
// Return the root of the Quad-Tree representing the grid. 
//
// Notice that you can assign the value of a node to True or False when isLeaf i
//s False, and both are accepted in the answer. 
//
// A Quad-Tree is a tree data structure in which each internal node has exactly 
//four children. Besides, each node has two attributes: 
//
// 
// val: True if the node represents a grid of 1's or False if the node represent
//s a grid of 0's. 
// isLeaf: True if the node is leaf node on the tree or False if the node has th
//e four children. 
// 
//
// 
//class Node {
//    public boolean val;
//    public boolean isLeaf;
//    public Node topLeft;
//    public Node topRight;
//    public Node bottomLeft;
//    public Node bottomRight;
//} 
//
// We can construct a Quad-Tree from a two-dimensional area using the following 
//steps: 
//
// 
// If the current grid has the same value (i.e all 1's or all 0's) set isLeaf Tr
//ue and set val to the value of the grid and set the four children to Null and st
//op. 
// If the current grid has different values, set isLeaf to False and set val to 
//any value and divide the current grid into four sub-grids as shown in the photo.
// 
// Recurse for each of the children with the proper sub-grid. 
// 
//
// If you want to know more about the Quad-Tree, you can refer to the wiki. 
//
// Quad-Tree format: 
//
// The output represents the serialized format of a Quad-Tree using level order 
//traversal, where null signifies a path terminator where no node exists below. 
//
// It is very similar to the serialization of the binary tree. The only differen
//ce is that the node is represented as a list [isLeaf, val]. 
//
// If the value of isLeaf or val is True we represent it as 1 in the list [isLea
//f, val] and if the value of isLeaf or val is False we represent it as 0. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,1],[1,0]]
//Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
//Explanation: The explanation of this example is shown below:
//Notice that 0 represnts False and 1 represents True in the photo representing 
//the Quad-Tree.
//
// 
//
// Example 2: 
//
// 
//
// 
//Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,
//1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]
//]
//Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[
//1,1]]
//Explanation: All values in the grid are not the same. We divide the grid into 
//four sub-grids.
//The topLeft, bottomLeft and bottomRight each has the same value.
//The topRight have different values so we divide it into 4 sub-grids where each
// has the same value.
//Explanation is shown in the photo below:
//
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,1],[1,1]]
//Output: [[1,1]]
// 
//
// Example 4: 
//
// 
//Input: grid = [[0]]
//Output: [[1,0]]
// 
//
// Example 5: 
//
// 
//Input: grid = [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]
//Output: [[0,1],[1,1],[1,0],[1,0],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// n == 2^x where 0 <= x <= 6 
// 
// 👍 247 👎 416


package com.leetcode.editor.en;

public class ConstructQuadTree{
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static void main(String[] args) {
       Solution solution = new ConstructQuadTree().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    //递归判断是否区域数字相同, 不相同继续分割
    /*public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int i1, int j1, int length){
        if(length <= 0) return null;
        for(int i = i1; i < i1 + length; i++){
            for(int j = j1; j < j1 + length; j++){
                if(grid[i][j] != grid[i1][j1]){
                    return new Node(true, false,
                            build(grid, i1, j1, length / 2),
                            build(grid, i1, j1 + length / 2, length / 2),
                            build(grid, i1 + length / 2, j1, length / 2),
                            build(grid, i1 + length / 2, j1 + length / 2, length / 2));
                }
            }
        }
        return new Node(grid[i1][j1] == 1, true, null, null, null, null);
    }*/


    public Node construct(int[][] grid){
        int n = grid.length;
        if(n == 0) return null;
        return helper(grid, 1, n, 1, n);
    }

    public Node helper(int[][] grid, int startX, int endX, int startY, int endY){
        int val = grid[startX - 1][startY - 1];
        boolean isSame = true;
        for(int i = startX - 1; i < endX; i++){
            for(int j = startY - 1; j < endY; j++){
                if(grid[i][j] != val){
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }
        //一样说明递归到底, 返回node
        if(isSame){
            Node n = new Node(val == 1 ? true : false, true, null, null, null, null);
            return n;
        }else{
            Node topLeft = helper(grid, startX, (startX + endX - 1) / 2, startY, (startY + endY - 1) / 2);
            Node topRight = helper(grid, startX, (startX + endX - 1) / 2, (startY + endY + 1) / 2, endY);
            Node bottomLeft = helper(grid, (startX + endX + 1) / 2, endX, startY, (startY + endY - 1) / 2);
            Node bottomRight = helper(grid, (startX + endX + 1) / 2, endX, (startY + endY + 1) / 2, endY);
            Node n = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
            return n;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}