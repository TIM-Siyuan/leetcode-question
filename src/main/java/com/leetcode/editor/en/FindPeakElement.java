//A peak element is an element that is greater than its neighbors. 
//
// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
// return its index. 
//
// The array may contain multiple peaks, in that case return the index to any on
//e of the peaks is fine. 
//
// You may imagine that nums[-1] = nums[n] = -∞. 
//
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5 
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, 
//             or index number 5 where the peak element is 6.
// 
//
// Note: 
//
// Your solution should be in logarithmic complexity. 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class FindPeakElement{
    public static void main(String[] args) {
       Solution solution = new FindPeakElement().new Solution();
       
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*// 考虑溢出问题, 所以首尾加入虚拟节点nums[-1] = nums[n] = -∞ 考虑
    // 但是当数组只有一个元素且为-∞没有峰值，所以一开始需要进行判断
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = newNums[newNums.length - 1] = Integer.MIN_VALUE;
        for(int i = 1; i < newNums.length - 1; i++){
            if(newNums[i] > newNums[i - 1] && newNums[i] > newNums[i + 1])
                //人为加了虚拟节点，所以最后返回i-1;
                return i - 1;
        }
        return -1;
    }*/

    //因为要取mid+1; 所以right值要合法;
    //left必须小于right否则right=mid死循环,但是不用担心返回值, 因为跳出循环返回的是right(此时left=right)
    public int findPeakElement(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[mid + 1]){
                right = mid;
            }
            else if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}