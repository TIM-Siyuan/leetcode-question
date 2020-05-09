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

public class TrappingRainWater{
    public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
       
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
    public int trap(int[] height){
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}