//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// Example: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 
// Related Topics Array Two Pointers Binary Search


package com.leetcode.editor.en;

public class TwoSumIiInputArrayIsSorted{
    public static void main(String[] args) {
       Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 2) throw new IllegalArgumentException("Illegal argument numbers");
        for(int i = 0; i < numbers.length-1; i++){
            int j = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(j != -1){
                int[] res = {i+1, j+1};
                return res;
            }
        }
        throw new IllegalArgumentException("The input is not solution");
    }

    public int binarySearch(int[] nums, int l, int r, int target){
        if(l < 0 || l > nums.length)
            throw new IllegalArgumentException("l is out of bound");
        if(r < 0 || r > nums.length)
            throw new IllegalArgumentException("r is out of bound");
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)
                return mid;
            if(target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}