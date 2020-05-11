//
//A string S of lowercase letters is given. We want to partition this string int
//o as many parts as possible so that each letter appears in at most one part, and
// return a list of integers representing the size of these parts.
// 
//
// Example 1: 
// 
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s S into less parts.
// 
// 
//
// Note: 
// S will have length in range [1, 500]. 
// S will consist of lowercase letters ('a' to 'z') only. 
// Related Topics Two Pointers Greedy


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels{
    public static void main(String[] args) {
       Solution solution = new PartitionLabels().new Solution();
       solution.partitionLabels("ababcbacadefegdehijhklij");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //相当于维护一个区间, 先记录每个元素的last位置, 遍历元素, 维护last最大保证包含所有元素, 当j+1 == last的时候说明这个区间外没有这个区间的元素了, 记录位置并断开
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();
        //temp记录上一次断开的位置, 下一次断开的时候需要相减求得下一个区间的长度
        int last = 0, temp = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            //i从0开始, 元素个数从1开始计算
            map.put(c, i + 1);
        }
        for(int j = 0; j < S.length(); j++){
            char c = S.charAt(j);
            last = Math.max(last, map.get(c));
            if(last == j + 1){
                res.add(last - temp);
                temp = (j + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}