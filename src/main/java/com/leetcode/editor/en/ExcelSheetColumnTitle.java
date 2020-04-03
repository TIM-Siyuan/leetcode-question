//Given a positive integer, return its corresponding column title as appear in a
//n Excel sheet. 
//
// For example: 
//
// 
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: 701
//Output: "ZY"
// Related Topics Math


package com.leetcode.editor.en;

public class ExcelSheetColumnTitle{
    public static void main(String[] args) {
       Solution solution = new ExcelSheetColumnTitle().new Solution();
       solution.convertToTitle(27);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int n) {
        /*String res = "";
        while(n != 0){
            res = (char)((n-1) % 26 + 'A') + res;
            n = (n-1) / 26;
        }
        return res;*/

        if(n == 0){
            return "";
        }
        else{
            System.out.println((char)('A' + (n % 26)));
            return convertToTitle(--n/26) + (char)('A' + (n % 26));
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}