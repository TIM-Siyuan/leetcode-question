//Given an array nums containing n + 1 integers where each integer is between 1 
//and n (inclusive), prove that at least one duplicate number must exist. Assume t
//hat there is only one duplicate number, find the duplicate one. 
//
// Example 1: 
//
// 
//Input: [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [3,1,3,4,2]
//Output: 3 
//
// Note: 
//
// 
// You must not modify the array (assume the array is read only). 
// You must use only constant, O(1) extra space. 
// Your runtime complexity should be less than O(n2). 
// There is only one duplicate number in the array, but it could be repeated mor
//e than once. 
// 
// Related Topics Array Two Pointers Binary Search


package com.leetcode.editor.en;

public class FindTheDuplicateNumber{
    public static void main(String[] args) {
       Solution solution = new FindTheDuplicateNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://blog.csdn.net/SoftPoeter/article/details/103153564
    //法一: 因为数组的特殊情况, 数组容量为n + 1, 所以数组不同元素有n, 所以当成指针不会越界; nums[i]指向index, 即nums[i]指向nums[index](nums[nums[i]])
    //nums[0]没有元素指向他, 因为[1, N]中有重复元素, 所以从重复元素一开始, 遇到重复元素二, 必跳回去形成环, 且环入口为重复元素
    /*public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0, t = 0;
        //相遇说明必有环
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow) break;
        }
        //求环入口
        while (true){
            slow = nums[slow]; //nums[slow] 等于 slow.next; 所以指的是slow这个index指向的内容
            t = nums[t];
            if(t == slow) break;
        }
        //所以最后返回t 而不是nums[t]
        return t;
    }*/

    //法二: 二分法 寻找右侧边界
    public int findDuplicate(int[] nums){
        int left = 1, right = nums.length;
        //left, right表明的是数值; 当left == right的时候, 即找到了两个重复元素
        while (left < right){
            int mid = left + (right - left) / 2, res = 0;
            //每次循环遍历一次数组, mid是数据真正的中点, 但是不知道mid的位置, 通过遍历数组来确定mid位置
            for(int num : nums){
                if(num <= mid) res++;
            }
            //如果没有重复元素, 则mid位置不变, 如果mid的位置靠左, 即右边的元素多了, 重复元素在右边;
            if(res <= mid) left = mid + 1;
            else right = mid;
        }
        //直接返回的是数值;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}