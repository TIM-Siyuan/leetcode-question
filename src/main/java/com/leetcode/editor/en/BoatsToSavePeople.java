//The i-th person has weight people[i], and each boat can carry a maximum weight
// of limit. 
//
// Each boat carries at most 2 people at the same time, provided the sum of the 
//weight of those people is at most limit. 
//
// Return the minimum number of boats to carry every given person. (It is guaran
//teed each person can be carried by a boat.) 
//
// 
//
// 
// Example 1: 
//
// 
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
// 
//
// 
// Example 2: 
//
// 
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
// 
//
// 
// Example 3: 
//
// 
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5) 
//
// Note: 
//
// 
// 1 <= people.length <= 50000 
// 1 <= people[i] <= limit <= 30000 
// 
// 
// 
// 
// Related Topics Two Pointers Greedy


package com.leetcode.editor.en;

import java.util.Arrays;

public class BoatsToSavePeople{
    public static void main(String[] args) {
       Solution solution = new BoatsToSavePeople().new Solution();
       int[] people = {1,2}; int limit = 3;
       solution.numRescueBoats(people, limit);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //high肯定上船, 所以high--; 但是看是否能带上low, 能的话low++, 不能的话low不变
    //当lo == hi的时候, 无论能不能带上这个都要一艘船, 所以不改变结果; 假如判断条件只是lo < hi, 则lo == hi这个结果没加上
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length, res = 0;
        Arrays.sort(people);
        for(int hi = n - 1, lo = 0; lo <= hi; hi--, res++){
            if(people[lo] + people[hi] <= limit) lo++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}