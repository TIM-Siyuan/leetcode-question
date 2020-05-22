//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers


package com.leetcode.editor.en;

import com.sun.scenario.effect.Brightpass;

public class ContainerWithMostWater{
    public static void main(String[] args) {
       Solution solution = new ContainerWithMostWater().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        /*int l = 0, r = height.length - 1, area = 0;
        while (l < r){
            int temp = Math.min(height[l], height[r]) * (r - l);
            area = Math.max(area, temp);
            if(height[l] < height[r]) l++;
            else r--;
        }
        return area;*/

        int l = 0, r = height.length - 1, area = 0;
        while (l < r){
            int h = Math.min(height[l], height[r]);
            int temp = h * (r - l);
            area = Math.max(area, temp);
            //如果与最小高度相等则不再计算容量, 因为距离变短肯定容量变小;
            //两者都相等两者同时移动, 假如只移动一边, 容量不可能变大;
            while (l < r && h == height[l]) l++;
            while (l < r && h == height[r]) r--;
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}