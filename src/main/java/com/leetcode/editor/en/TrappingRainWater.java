//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack


package com.leetcode.editor.en;

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
       int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
       solution.trap(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //备忘录优化; 算出左右的l_max, r_max; 再遍历相加可得雨水的值
 /*   public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++){
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        for(int i = 1; i < n - 1; i++){
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }*/

    //双指针
    /*public int trap(int[] height){
        if(height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int l_max = height[0];
        int r_max = height[n - 1];
        while (left <= right){
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if(l_max < r_max){
                res += l_max - height[left];
                left++;
            }
            else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }*/

    //Stack
    /*public int trap(int[] height){
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }*/

    //单调栈
    public int trap(int[] height){
        int n = height.length;
        if(n < 2) return 0;
        //高度
        Stack<Integer> sth = new Stack<Integer>();
        //宽度(坐标)
        Stack<Integer> sti = new Stack<Integer>();
        int res = 0;
        int maxh = 0;
        for(int i = 0; i < n; i++){
            int nh = height[i];
            //维护单调栈:
            //如果现在的高度大于之前的最高高度, 将比其小的元素都剔除并计算可存水量; 压入最高高度, 其左边的值(均小于最高值的)已经没有意义
            if(nh >= maxh){
                while (!sth.isEmpty()) {
                    int h = sth.pop();
                    int j = sti.pop();
                    //如果pop了之后栈为空说明此为左壁, 即之前的最高值, 不能再装任何水, 所以退出
                    if(sth.isEmpty()) break;
                    res += (j - sti.peek()) * (maxh - h);
                }
                maxh = nh;
                sth.push(nh);
                sti.push(i);
            }
            //如果比最高小(所以栈必不可能为空), 但是比某几个元素大, 水量计算方法相同;
            //此时相当于一层一层的填充水量(水平填充); 因为最小值被剔除, 相当于更低的那层已经被填满消失, 后续可能填充同一位置更高的一层
            else { // nh < maxh
                while (sth.peek() <= nh){
                    int h = sth.pop();
                    int j = sti.pop();
                    res += (j - sti.peek()) * (nh - h);
                }
                sth.push(nh);
                sti.push(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}