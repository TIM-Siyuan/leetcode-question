//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


package com.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
       Solution solution = new LargestRectangleInHistogram().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Brute-force: O(n^2) 491ms 41MB
    //从左到右遍历找到高点并记录结果 --> 因为低柱会限制高柱子, 高柱不会限制低柱, 所以在高柱前的低柱计算结果肯定不会是最大的, 即遇到高柱后的下一个低柱前应该计算此时可得的结果并记录
    /*public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int max = 0;
        for(int curr = 0; curr < heights.length; curr++){
            if(curr == heights.length - 1 || heights[curr] >= heights[curr + 1]){
                int minHeight = heights[curr];
                for(int idx = curr; idx >= 0; idx--){
                    minHeight = Math.min(minHeight, heights[idx]);
                    max = Math.max(max, minHeight * (curr - idx + 1));
                }
            }
        }
        return max;
    }*/

    //Monotonic Stack: O(n)
    /*public int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0) return 0;
        int max = 0;
        //stk存入的是柱子下标 -> 因为需要弹出栈 / 计算宽度, 所以记录下标方便; 存高度无法计算宽度且可能重复
        Stack<Integer> stk = new Stack<>();
        for(int cur = 0; cur < heights.length; cur++){
            if(stk.isEmpty() || heights[cur] >= heights[stk.peek()]){
                stk.push(cur);
            }
            else {
                //存的是高点的下一个index
                int right = cur;
                //需要计算的高点
                int index = stk.pop();
                //跳过相同的高度的值, 减少重复计算
                while (!stk.isEmpty() && heights[index] == heights[stk.peek()]){
                    index = stk.pop();
                }
                //高点左边的下标; 这样计算的好处就是只剩一个元素的时候, index = 0, 其宽度为 0 - (-1) = 1
                int leftMost = (stk.isEmpty()) ? -1 : stk.peek();
                //right是高点的下一个index所以要先减一
                max = Math.max(max, (right - leftMost - 1) * heights[index]);
                //因为每次循环cur++, 但还要继续考虑right这个index的值, 所以提前--
                cur--;
            }
        }
        //维护完一个increasing stack之后, 计算里面的值
        //因为递增栈所有的right边界是一样的, 所以统一stk.peek() + 1
        int rightMost = stk.peek() + 1;
        while (!stk.isEmpty()){
            int index = stk.pop();
            int left = (stk.isEmpty()) ? -1 : stk.peek();
            max = Math.max(max, (rightMost - left - 1) * heights[index]);
        }
        return max;
    }*/

    //单调栈2 直接利用stk计算index, 减少代码复杂性
    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1); //为了最后计算index=0的宽度
        int max = 0;
        for(int i = 0; i < n; i++){
            while (stk.peek() != -1 && heights[stk.peek()] >= heights[i]){
                max = Math.max(max, heights[stk.pop()] * (i - stk.peek() - 1));
            }
            stk.push(i);
        }

        while (stk.peek() != -1){
            max = Math.max(max, heights[stk.pop()] * (n - stk.peek() - 1));
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}