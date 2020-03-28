//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap


package com.leetcode.editor.en;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
       int[] arr = {3,2,3,1,2,4,5,5,6};
       solution.findKthLargest(arr, 4);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return process(nums, 0, nums.length-1, k-1);
    }

    public int process(int[] arr, int l, int r, int k){
        if(l == r) return arr[l];
        int[] p = partition(arr, l , r, arr[l+(int)(Math.random()*(r-l+1))]);
        if(k >= p[0] && k <= p[1])
            return arr[k];
        else if(k < p[0])
            return process(arr, l, p[0]-1, k);
        else
            return process(arr, p[1]+1, r, k);
    }

    public int[] partition(int[] arr, int l, int r, int num){
        int less = l-1;
        int more = r+1;
        int cur = l;
        while (cur < more){
            if(arr[cur] > num){
                swap(arr, ++less, cur++);
            }
            else if(arr[cur] < num){
                swap(arr, --more, cur);
            }
            else{
                cur++;
            }
        }
        return new int[]{less+1, more-1};
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}