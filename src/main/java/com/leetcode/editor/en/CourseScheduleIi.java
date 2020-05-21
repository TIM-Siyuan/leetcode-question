//There are a total of n courses you have to take, labeled from 0 to n-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, return th
//e ordering of courses you should take to finish all courses. 
//
// There may be multiple correct orders, you just need to return one of them. If
// it is impossible to finish all courses, return an empty array. 
//
// Example 1: 
//
// 
//Input: 2, [[1,0]] 
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished   
//             course 0. So the correct course order is [0,1] . 
//
// Example 2: 
//
// 
//Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,1,2,3] or [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both     
//             courses 1 and 2. Both courses 1 and 2 should be taken after you f
//inished course 0. 
//             So one correct course order is [0,1,2,3]. Another correct orderin
//g is [0,2,1,3] . 
//
// Note: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
//


package com.leetcode.editor.en;

import java.util.*;

public class CourseScheduleIi{
    public static void main(String[] args) {
       Solution solution = new CourseScheduleIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph =  new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(course).add(pre);
            inDegree[course]++;
        }
        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            ArrayList<Integer> toTake = graph.get(cur);
            for(int i = 0; toTake != null && i < toTake.size(); i++){
                inDegree[toTake.get(i)]--;
                if(inDegree[toTake.get(i)] == 0) q.offer(toTake.get(i));
            }
            res[count] = cur;
            count++;
        }

        return count == numCourses ? res : new int[0];
    }*/

    public int[] findOrder(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(pre).add(course);
        }

        int[] visited = new int[numCourses];
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(dfs(res, graph, visited, i)) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            //因为res从底开始添加visited数字, 所以反向输出才是正确的prerequisite;
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    private boolean dfs(List<Integer> res, ArrayList<ArrayList<Integer>> graph, int[] visited, int cur){
        if(visited[cur] == 1) return true;
        if(visited[cur] == 2) return false;

        visited[cur] = 1;
        for(int next : graph.get(cur)){
            if(dfs(res, graph, visited, next)) return true;
        }

        //递归到底visited的才会加入res, 应该放在最尾端, 但现在是正向相加, 所以上面需要反向输出
        res.add(cur);
        visited[cur] = 2;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}