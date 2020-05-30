//
//In this problem, a rooted tree is a directed graph such that, there is exactly
// one node (the root) for which all other nodes are descendants of this node, plu
//s every node has exactly one parent, except for the root node which has no paren
//ts.
// 
//The given input is a directed graph that started as a rooted tree with N nodes
// (with distinct values 1, 2, ..., N), with one additional directed edge added. T
//he added edge has two different vertices chosen from 1 to N, and was not an edge
// that already existed.
// 
//The resulting graph is given as a 2D-array of edges. Each element of edges is 
//a pair [u, v] that represents a directed edge connecting nodes u and v, where u 
//is a parent of child v.
// 
//Return an edge that can be removed so that the resulting graph is a rooted tre
//e of N nodes. If there are multiple answers, return the answer that occurs last 
//in the given 2D-array.
// Example 1: 
// 
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given directed graph will be like this:
//  1
// / \
//v   v
//2-->3
// 
// 
// Example 2: 
// 
//Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//Output: [4,1]
//Explanation: The given directed graph will be like this:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
// 
// 
// Note: 
// The size of the input 2D-array will be between 3 and 1000. 
// Every integer represented in the 2D-array will be between 1 and N, where N is
// the size of the input array. 
// Related Topics Tree Depth-first Search Union Find Graph


package com.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnectionIi{
    public static void main(String[] args) {
       Solution solution = new RedundantConnectionIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //有向图有三种情况(利用出入度判断)
    // 1. 有环，无入度2的节点 == 一个parent: UF处理有环 -> 返回此边
    // 2. 无环，有入度2的节点 == 两个parent: 返回second;
    // 3. 有环，有入度2的节点 == 两个parent: 有环, 只有一个入度在环内 -> 返回first(即环内那一条); 有环, 两个入度都在环内 -> 返回second;
    // ——> 如何判断？记录下来edge[1] = 0 -> 遍历时跳过则会出现不同情况
    /*public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] first = {-1, -1}, second = {-1, -1}, parent = new int[n + 1];
        //step1: check whether there is a node with two parents
        for(int[] edge : edges){
            //初始化parent为0, 所以假如为0证明还未遍历
            if(parent[edge[1]] == 0) //if y.father is null,let x be y'sfather
                //再遇到下一个入度即可判断得其有两个入度
                parent[edge[1]] = edge[0];
            else {
                first = new int[]{parent[edge[1]], edge[1]}; //if y.father is not null, record {father,y} and {x,y}, let y = 0 (x->0)
                second = new int[]{edge[0], edge[1]};
                edge[1] = 0; //set the current link invalid, 相当于标记second, 后续union时跳过
            }
        }
        //step 2: union find
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        //union
        for(int i = 0; i < n; i++){
            //跳过edge, 假如一入度在环内, 一路通畅遇到环返回; 假如两入度都在环内, 则一路通畅最后形成环时跳出返回second(假如不标记进入循环判断会返回first)
            if(edges[i][1] == 0) continue;
            int child = edges[i][1], father = edges[i][0];
            if(find(parent, father) == child){  //有环
                //没入度2的节点? 此边: first
                if(first[0] == -1) return edges[i];
                return first;
            }
            //无环 union
            parent[child] = father;
        }
        return second;
    }

    private int find(int[] parent, int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }*/

    //法二: 效率低, 每一个节点都要新建uf再检测环, 但是可以当follow up -- 有向图需要根据入度判断, 并设立一个标记, 找环时跳过则可返回不在环内的那条边
    class UnionFind{
        private int[] parent;
        private int[] size;
        public UnionFind(int n){
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
            if (rootX == rootY) return false;

            if(size[rootX] > size[rootY]){
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            return true;
        }

        public int find(int x){
            if(parent[x] != x){
                x = find(parent[x]);
            }
            return x;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges){
        Map<Integer, Integer> incoming = new HashMap<>();
        //初始化入度为2的节点
        int node = -1;
        for(int[] e : edges){
            incoming.put(e[1], incoming.getOrDefault(e[1], 0) + 1);
            if(incoming.get(e[1]) == 2)
                node = e[1]; //标记second
        }

        if(node == -1){
            //有环无入度为2, 同题1直接UF
            return findRedundantConnection(edges, -1);
        }
        else{
            //逆序遍历, 则先遇到second, 即跳过second
            for(int i = edges.length - 1; i >= 0; i--){
                if(edges[i][1] == node){
                    //有环: 因为设立了skip函数, 所以假如在环内被跳过, 返回null / 直接返回first
                    int[] res = findRedundantConnection(edges, i);
                    //无环返回second / 有环被跳过返回null
                    if(res == null) return edges[i];
                }
            }
        }
        return null;
    }

    //复用无向图的函数, 加入skip参数跳过second
    private int[] findRedundantConnection(int[][] edges, int skip) {
        int n = edges.length;
        //因为题目从1开始, uf从0开始计数, 所以需要n + 1的位置
        UnionFind uf = new UnionFind(n + 1);

        for(int i = 0; i < n; i++){
            if(i == skip) continue;
            if(!uf.union(edges[i][0], edges[i][1])) return edges[i];
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}