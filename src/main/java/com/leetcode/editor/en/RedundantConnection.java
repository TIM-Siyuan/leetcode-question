//
//In this problem, a tree is an undirected graph that is connected and has no cy
//cles.
// 
//The given input is a graph that started as a tree with N nodes (with distinct 
//values 1, 2, ..., N), with one additional edge added. The added edge has two dif
//ferent vertices chosen from 1 to N, and was not an edge that already existed.
// 
//The resulting graph is given as a 2D-array of edges. Each element of edges is 
//a pair [u, v] with u < v, that represents an undirected edge connecting nodes u 
//and v.
// 
//Return an edge that can be removed so that the resulting graph is a tree of N 
//nodes. If there are multiple answers, return the answer that occurs last in the 
//given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
//
// Example 1: 
// 
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given undirected graph will be like this:
//  1
// / \
//2 - 3
// 
// 
// Example 2: 
// 
//Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//Output: [1,4]
//Explanation: The given undirected graph will be like this:
//5 - 1 - 2
//    |   |
//    4 - 3
// 
// 
// Note: 
// The size of the input 2D-array will be between 3 and 1000. 
// Every integer represented in the 2D-array will be between 1 and N, where N is
// the size of the input array. 
// 
//
// 
//
// 
//Update (2017-09-26): 
//We have overhauled the problem description + test cases and specified clearly 
//the graph is an undirected graph. For the directed graph follow up please see Re
//dundant Connection II). We apologize for any inconvenience caused.
// Related Topics Tree Union Find Graph


package com.leetcode.editor.en;

public class RedundantConnection{
    public static void main(String[] args) {
       Solution solution = new RedundantConnection().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*class DSU{
        int[] root;
        int[] size;

        public DSU(int n){
            root = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                root[i] = i;
            }
        }

        public int find(int x){
            if(root[x] != x){
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false;
            if(size[rootX] < size[rootY]){
                root[rootX] = rootY;
                size[rootY]++;
            }
            else {
                root[rootY] = rootX;
                size[rootX]++;
            }
            return true;
        }
    }*/
    class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;

        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return false;

            if(size[rootX] > size[rootY]){
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            count--;
            return true;
        }

        private int find(int x){
            //进行了路径压缩, 要稍慢
            while (parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        //因为题目从1开始, uf从0开始计数, 所以需要n + 1的位置
        UnionFind uf = new UnionFind(n + 1);

        for(int[] e : edges){
            if(!uf.union(e[0], e[1])) return e;
        }

        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}