//Given an undirected graph, return true if and only if it is bipartite. 
//
// Recall that a graph is bipartite if we can split it's set of nodes into two i
//ndependent subsets A and B such that every edge in the graph has one node in A a
//nd another node in B. 
//
// The graph is given in the following form: graph[i] is a list of indexes j for
// which the edge between nodes i and j exists. Each node is an integer between 0 
//and graph.length - 1. There are no self edges or parallel edges: graph[i] does n
//ot contain i, and it doesn't contain any element twice. 
//
// 
//Example 1:
//Input: [[1,3], [0,2], [1,3], [0,2]]
//Output: true
//Explanation: 
//The graph looks like this:
//0----1
//|    |
//|    |
//3----2
//We can divide the vertices into two groups: {0, 2} and {1, 3}.
// 
//
// 
//Example 2:
//Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
//Output: false
//Explanation: 
//The graph looks like this:
//0----1
//| \  |
//|  \ |
//3----2
//We cannot find a way to divide the set of nodes into two independent subsets.
// 
//
// 
//
// Note: 
//
// 
// graph will have length in range [1, 100]. 
// graph[i] will contain integers in range [0, graph.length - 1]. 
// graph[i] will not contain i or duplicate values. 
// The graph is undirected: if any element j is in graph[i], then i will be in g
//raph[j]. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph


package com.leetcode.editor.en;

public class IsGraphBipartite{
    public static void main(String[] args) {
       Solution solution = new IsGraphBipartite().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[] visited;
    private int[] colors;
    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int V = graph.length;
        visited = new boolean[V];
        colors = new int[V];
        for(int v = 0; v < V; v++)
            if(!visited[v])
                if(!dfs(v, 0)) return false;
        return true;
    }

    private boolean dfs(int v, int color){
        visited[v] = true;
        colors[v] = color;
        for(int w : graph[v])
            if(!visited[w]){
                if(!dfs(w, 1-color)) return false;
            }
            else if(colors[v] == colors[w]){
                return false;
            }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}