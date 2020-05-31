//
//There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend 
//of B, and B is a direct friend of C, then A is an indirect friend of C. And we d
//efined a friend circle is a group of students who are direct or indirect friends
//.
// 
//
// 
//Given a N*N matrix M representing the friend relationship between students in 
//the class. If M[i][j] = 1, then the ith and jth students are direct friends with
// each other, otherwise not. And you have to output the total number of friend ci
//rcles among all the students.
// 
//
// Example 1: 
// 
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a frie
//nd circle. The 2nd student himself is in a friend circle. So return 2.
// 
// 
//
// Example 2: 
// 
//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd stude
//nts are direct friends, so the 0th and 2nd students are indirect friends. All of
// them are in the same friend circle, so return 1.
// 
// 
//
//
// Note: 
// 
// N is in range [1,200]. 
// M[i][i] = 1 for all students. 
// If M[i][j] = 1, then M[j][i] = 1. 
// 
// Related Topics Depth-first Search Union Find


package com.leetcode.editor.en;

public class FriendCircles{
    public static void main(String[] args) {
       Solution solution = new FriendCircles().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //UnionFind
    /*class UnionFind{
        private int count = 0;
        private int[] parent;
        private int[] size;
        public UnionFind(int n){
            count = n;
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;

            if(size[rootX] > size[rootY]){
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            count--;
        }

        public int find(int x){
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        private int count(){
            return count;
        }
    }
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        //M[i][j] == M[j][i] 所以扫描上三角即可
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }*/

    //DFS + visited
    //dfs -> 找出i同学的所有朋友
    /*public void dfs(int[][] M, boolean[] visited, int i){
        //由上到下的扫描
        for(int j = 0; j < M[0].length; j++){
            if(M[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M){
        boolean[] visited = new boolean[M.length];
        int count = 0;
        //从左到右的扫描
        for(int i = 0; i < M.length; i++){
            //i学生未被访问过 -> dfs将其所有朋友都设为1
            if(!visited[i]){
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }*/

    //DFS not extra space -> modify matrix
    public void dfs(int[][] M, int i) {
        //表明该节点index前已经全部访问过, 此节点可以无需访问, 直接返回提升效率 -> 因为只需要访问下三角
        if(M[i][i] == 0) return;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                M[i][j] = M[j][i] = 0; //设为0表明已经访问过;
                dfs(M, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}