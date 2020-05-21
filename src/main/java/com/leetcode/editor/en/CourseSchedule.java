//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, is it pos
//sible for you to finish all courses? 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is poss
//ible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take c
//ourse 0 you should
//             also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 1 <= numCourses <= 10^5 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
//


package com.leetcode.editor.en;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.*;

public class CourseSchedule{
    public static void main(String[] args) {
       Solution solution = new CourseSchedule().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            inDegree[course]++;
            if(graph.containsKey(pre)){
                graph.get(pre).add(course);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(course);
                graph.put(pre, list);
            }
        }
        //BFS
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            List<Integer> toTake = graph.get(cur);
            for(int i = 0; toTake != null && i < toTake.size(); i++){
                inDegree[toTake.get(i)]--;
                if(inDegree[toTake.get(i)] == 0) q.offer(toTake.get(i));
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] != 0) return false;
        }

        return true;
    }*/


    //DFS 寻找是否有环--不断寻找neighbor如果遇到了visiting的说明的有环返回false
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        //ArrayList比HashMap快
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(course).add(pre);
        }
        //state: 0-unknown 1-visiting 2-visited
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, graph, visited)) return false;
        }
        return true;
    }

    private boolean dfs(int cur, ArrayList<ArrayList<Integer>> graph, int[] visited){
        if(visited[cur] == 1) return true;
        if(visited[cur] == 2) return false; //跳过已经visited的节点, 如果使用boolean只有两种状态, 表示可形成环, 不可形成环; 缺少unknown, 无法区分是否已经计算过

        visited[cur] = 1;

        for(int next : graph.get(cur)){
            if(dfs(next, graph, visited)) return true;
        }

        visited[cur] = 2;
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}