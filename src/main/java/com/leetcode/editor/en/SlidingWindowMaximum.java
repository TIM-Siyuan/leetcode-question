//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics Heap Sliding Window


package com.leetcode.editor.en;

import java.util.LinkedList;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class MonotonicQueue{ //利用双端队列形成的递减单调队列
        private LinkedList<Integer> deque = new LinkedList<>();
        public void push(int num){
            while(!deque.isEmpty() && deque.getLast() < num)
                deque.removeLast();
            deque.addLast(num);
        }

        public int max(){
            return deque.getFirst();
        }

        public void pop(int num){
            if(!deque.isEmpty() && deque.getFirst() == num)
                deque.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        if(k == 1) return nums;
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){ //把k-1填满, 这样取最值的操作都放在else执行
                window.push(nums[i]);
            }else { // i - k + 1 : 窗口的最左index
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}