//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics Math Binary Search


package com.leetcode.editor.en;

public class Sqrtx{
    public static void main(String[] args) {
       Solution solution = new Sqrtx().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //可以使用普通二分, 取等条件设置范围, 因为mid是int型, 所以向下取整可得到确定值
  /*  public int mySqrt(int x) {
        int left = 0, right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(Math.pow(mid, 2) <= x && Math.pow(mid + 1, 2) > x){
                return mid;
            }
            else if(Math.pow(mid, 2) > x){
                right = mid - 1;
            }
            else if(Math.pow(mid, 2) < x){
                left = mid + 1;
            }
        }
        return -1;
    }*/

    //找一个不大于目标的数值 == 寻找右侧边界; 这样取得target条件不用设置范围
    public int mySqrt(int x) {
        if (x <= 1) return x;
        //因为x是数值, 一个数的平方根不可能大于其本身
        //已经判断x >= 1, 所以left == x取不到, 相当于开区间
        //且假如x是最大整型数, x + 1越界
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 或者用 x / mid >= mid 判断
            if (Math.pow(mid, 2) <= x)

                left = mid + 1;
            else if(Math.pow(mid, 2) > x)
                right = mid;
        }
        return right - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}