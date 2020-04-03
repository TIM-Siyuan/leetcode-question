//Given a column title as appear in an Excel sheet, return its corresponding col
//umn number. 
//
// For example: 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// Example 1: 
//
// 
//Input: "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: "ZY"
//Output: 701
// Related Topics Math


package com.leetcode.editor.en;

import java.util.HashMap;

public class ExcelSheetColumnNumber{
    public static void main(String[] args) {
       Solution solution = new ExcelSheetColumnNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = res*26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}