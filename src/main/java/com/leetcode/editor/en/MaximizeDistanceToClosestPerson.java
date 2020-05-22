//In a row of seats, 1 represents a person sitting in that seat, and 0 represent
//s that the seat is empty. 
//
// There is at least one empty seat, and at least one person sitting. 
//
// Alex wants to sit in the seat such that the distance between him and the clos
//est person to him is maximized. 
//
// Return that maximum distance to closest person. 
//
// 
// Example 1: 
//
// 
//Input: [1,0,0,0,1,0,1]
//Output: 2
//Explanation: 
//If Alex sits in the second open seat (seats[2]), then the closest person has d
//istance 2.
//If Alex sits in any other open seat, the closest person has distance 1.
//Thus, the maximum distance to the closest person is 2. 
//
// 
// Example 2: 
//
// 
//Input: [1,0,0,0]
//Output: 3
//Explanation: 
//If Alex sits in the last seat, the closest person is 3 seats away.
//This is the maximum distance possible, so the answer is 3.
// 
//
// Note: 
//
// 
// 1 <= seats.length <= 20000 
// seats contains only 0s or 1s, at least one 0, and at least one 1. 
// 
// 
// 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.Enumeration;

public class MaximizeDistanceToClosestPerson{
    public static void main(String[] args) {
       Solution solution = new MaximizeDistanceToClosestPerson().new Solution();
       int[] seats = {1, 0,0,0,0,0,1};
       solution.maxDistToClosest(seats);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Two Pointers
   /* public int maxDistToClosest(int[] seats) {
        *//*int res = 0, n = seats.length, last = -1;
        int start = -1, mid = -1, end = -1;
        for(int i = 0; i < n; i++){
           if(seats[i] == 1 && last == -1) {
               res = i;
               last = i;
           }
           else if(seats[i] == 1 && last != -1){
               mid = (i - last) / 2;
               last = i;
           }
           res = Math.max(res, mid);
        }
        res = Math.max(res, n - last - 1);
        return res;*//*
        int res = 0, n = seats.length, last = -1;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }*/

    //One pass
    public int maxDistToClosest(int[] seats){
        int res = 0, i = 0, n = seats.length;
        while (i < n){
            while (i < n && seats[i] == 1){
                i++;
            }
            int j = i - 1; //记录1出现的位置
            //经过while之后i出现的位置是下一个1出现的位置 or i == n, 即i - 1的位置为0;
            while (i < n && seats[i] == 0){
                i++;
            }
            //j == -1 --> 1未在i = 0处出现 || i == n --> i - 1的位置为0 --> seats[n-1] == 0;
            if(j == -1 || i == n){ //首尾不是1
                res = Math.max(res, i - j - 1); // i - 1的位置为0, 所以需要 i - 1 - j;
            }
            else {
                res = Math.max(res, (i - j) / 2); //i, j均为1出现的index, 直接相减 / 2;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}