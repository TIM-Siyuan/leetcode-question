## [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/>) 题解

### 题目描述:

In a given grid, each cell can have one of three values:

- the value `0` representing an empty cell;
- the value `1` representing a fresh orange;
- the value `2` representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return `-1` instead.

![img](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)

**Example 1:**

```
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

**Example 2:**

```
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
```

**Example 3:**

```
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
```



### 题目分析

一道BFS的变型题, 输出结果为遍历完全所需的步数．主框架使用BFS的经典模板.

> Hint 1: BFS模板

```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数
    
    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```

> Hint 2: 需要设置参数fresh判断corner case情况

- Corner case 1: 假如遍历完全依然有未能遍历的orange 返回-1 (example 2)

- Corner case 2: 假如一开始就不存在可遍历的fresh orange 返回0 (example 3)

> Hint 3: 二维坐标与一位坐标的相互转换

```java
//二维转一维 n为列数; 
cur = row * n + col
//一维转二维
int row = cur / n;
int col = cur % n;
```



### 代码

```java
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] grid;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        this.grid = grid;
        int m = grid.length, n = grid[0].length, count = 0, fresh = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(i * n + j); //二维转一维
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                int x = cur / n;
                int y = cur % n;
                for(int[] dir : dirs){
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if(inArea(nextX, nextY) && grid[nextX][nextY] == 1){
                        grid[nextX][nextY] = 2;
                        q.offer(nextX * n + nextY);
                        fresh--;
                    }
                }
            }
            count++;
            if(fresh == 0){
                break;
            }
        }
        return fresh == 0 ? count : -1;
    }
    
    private boolean inArea(int x, int y){
        return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1;
    }
}
```

