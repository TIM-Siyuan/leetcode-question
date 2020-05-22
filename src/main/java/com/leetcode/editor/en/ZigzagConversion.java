//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
// Related Topics String


package com.leetcode.editor.en;

public class ZigzagConversion{
    public static void main(String[] args) {
       Solution solution = new ZigzagConversion().new Solution();
       solution.convert("PAYPALISHIRING", 3);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        int len = s.length(), idx = 0;
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        while (idx < len) {
            for(int i = 0; i < numRows && idx < len; i++, idx++){
                sb[i].append(s.charAt(idx));
            }
            for(int i = numRows - 2; i > 0 && idx < len; i--, idx++){
                sb[i].append(s.charAt(idx));
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}