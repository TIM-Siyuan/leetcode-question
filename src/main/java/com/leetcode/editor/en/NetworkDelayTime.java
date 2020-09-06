//There are N network nodes, labelled 1 to N. 
//
// Given times, a list of travel times as directed edges times[i] = (u, v, w), w
//here u is the source node, v is the target node, and w is the time it takes for 
//a signal to travel from source to target. 
//
// Now, we send a signal from a certain node K. How long will it take for all no
//des to receive the signal? If it is impossible, return -1. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//Output: 2
// 
//
// 
//
// Note: 
//
// 
// N will be in the range [1, 100]. 
// K will be in the range [1, N]. 
// The length of times will be in the range [1, 6000]. 
// All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100. 
// 
// Related Topics Heap Depth-first Search Breadth-first Search Graph


package com.leetcode.editor.en;

import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class NetworkDelayTime{
    public static void main(String[] args) {
       Solution solution = new NetworkDelayTime().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Dijkstra
    /*public int networkDelayTime(int[][] times, int N, int K) {
        //邻接表建图
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[N + 1];
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        pq.offer(new int[]{0, K});
        int max = 0;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int curNode = curr[1];
            //因为使用堆存在多个不同距离的Node, 如果已经遍历完全则退出循环
            if(visited[curNode]) continue;

            visited[curNode] = true;
            int curDis = curr[0];
            max = curDis;
            //N来记录是否能遍历完全
            N--;
            if(!graph.containsKey(curNode)) continue;
            for(int[] next : graph.get(curNode)){
                if(!visited[next[0]] && curDis + next[1] < minDis[next[0]]){
                    pq.offer(new int[]{curDis + next[1], next[0]});
                }
            }
        }
        return N == 0 ? max : -1;
    }*/

    //Bellman-Ford
    /*public int networkDelayTime(int[][] times, int N, int K){
        double[] disTo = new double[N];
        Arrays.fill(disTo, Double.POSITIVE_INFINITY);
        disTo[K - 1] = 0;
        for(int i = 1; i < N; i++){
            for(int[] edge : times){
                int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
                disTo[v] = Math.min(disTo[v], disTo[u] + w);
            }
        }
        double res = Double.MIN_VALUE;
        for(double i : disTo) {
            res = Math.max(i, res);
        }
        return res == Double.POSITIVE_INFINITY ? -1 : (int)res;
    }*/

    //Floyd
    public int networkDelayTime(int[][] times, int N, int K){
        double[][] disTo = new double[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(disTo[i], Double.POSITIVE_INFINITY);
        }
        for(int i = 0; i < N; i++){
            disTo[i][i] = 0;
        }
        for (int[] edge : times){
            disTo[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(disTo[i][j] > disTo[i][k] + disTo[k][j])
                        disTo[i][j] = disTo[i][k] + disTo[k][j];
                }
            }
        }

        double max = Double.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(disTo[K - 1][i] == Double.POSITIVE_INFINITY) return -1;
            max = Math.max(max, disTo[K - 1][i]);
        }

        return (int)max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}