//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //利用二分不断更新最小值; 左边有序则最小值一定在右边; 反之亦然
    /*public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
               right = mid - 1;
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }*/

    //最小值在左边, 中间值一定小于右边界;
    //因为需要mid, mid+1相互比较; 所以left或者right需要一个为mid, 不然跳过了mid
    //此处right=mid, 因为需要nums[right]进行比较
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}