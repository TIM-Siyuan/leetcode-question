//Given an array A, we can perform a pancake flip: We choose some positive integ
//er k <= A.length, then reverse the order of the first k elements of A. We want t
//o perform zero or more pancake flips (doing them one after another in succession
//) to sort the array A. 
//
// Return the k-values corresponding to a sequence of pancake flips that sort A.
// Any valid answer that sorts the array within 10 * A.length flips will be judged
// as correct. 
//
// 
//
// Example 1: 
//
// 
//Input: [3,2,4,1]
//Output: [4,2,4,3]
//Explanation: 
//We perform 4 pancake flips, with k values 4, 2, 4, and 3.
//Starting state: A = [3, 2, 4, 1]
//After 1st flip (k=4): A = [1, 4, 2, 3]
//After 2nd flip (k=2): A = [4, 1, 2, 3]
//After 3rd flip (k=4): A = [3, 2, 1, 4]
//After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
// 
//
// 
// Example 2: 
//
// 
//Input: [1,2,3]
//Output: []
//Explanation: The input is already sorted, so there is no need to flip anything
//.
//Note that other answers, such as [3, 3], would also be accepted.
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= A.length <= 100 
// A[i] is a permutation of [1, 2, ..., A.length] 
// 
// Related Topics Array Sort


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting{
    public static void main(String[] args) {
       Solution solution = new PancakeSorting().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> pancakeSort(int[] A) {
        sort(A, A.length);
        return res;
    }

    private void sort(int[] cakes, int n){
        if(cakes.length == 0 || n == 1) return;

        // 寻找最大饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for(int i = 0; i < n; i++){
            if(cakes[i] > maxCake){
                maxCake = cakes[i];
                maxCakeIndex = i;
            }
        }

        // 第一次翻转，将最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex);
        // 第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, n);
        res.add(n);
        // 递归调用
        sort(cakes, n - 1);
    }

    private void reverse(int[] arr, int i, int j){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}