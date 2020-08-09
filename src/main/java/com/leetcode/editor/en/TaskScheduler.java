//You are given a char array representing tasks CPU need to do. It contains capi
//tal letters A to Z where each letter represents a different task. Tasks could be
// done without the original order of the array. Each task is done in one unit of 
//time. For each unit of time, the CPU could complete either one task or just be i
//dle. 
//
// However, there is a non-negative integer n that represents the cooldown perio
//d between two same tasks (the same letter in the array), that is that there must
// be at least n units of time between any two same tasks. 
//
// You need to return the least number of units of times that the CPU will take 
//to finish all the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// The number of tasks is in the range [1, 10000]. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics Array Greedy Queue 
// 👍 3540 👎 706


package com.leetcode.editor.en;

public class TaskScheduler{
    public static void main(String[] args) {
       Solution solution = new TaskScheduler().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //本质是寻找会留多少个空位, 假如n大于一轮所需空位数的话
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        //most frequency task
        int max = 0;
        //count of tasks with most frequency
        int maxCount = 0;
        for(char task : tasks){
            counter[task - 'A']++;
            if(max == counter[task - 'A']){
                maxCount++;
            }
            else if(max < counter[task - 'A']){
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}