//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added toge
//ther. Twelve is written as, XII, which is simply X + II. The number twenty seven
// is written as XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. Input is guaranteed to be wi
//thin the range from 1 to 3999. 
//
// Example 1: 
//
// 
//Input: "III"
//Output: 3 
//
// Example 2: 
//
// 
//Input: "IV"
//Output: 4 
//
// Example 3: 
//
// 
//Input: "IX"
//Output: 9 
//
// Example 4: 
//
// 
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String


package com.leetcode.editor.en;

public class RomanToInteger{
    public static void main(String[] args) {
       Solution solution = new RomanToInteger().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int romanToInt(String s) {
        int sum=0;
        //一个字符串中每种相减的情况最多只可能出现一次
        if(s.indexOf("IV")!=-1){sum -= 2;}
        if(s.indexOf("IX")!=-1){sum -= 2;}
        if(s.indexOf("XL")!=-1){sum -= 20;}
        if(s.indexOf("XC")!=-1){sum -= 20;}
        if(s.indexOf("CD")!=-1){sum -= 200;}
        if(s.indexOf("CM")!=-1){sum -= 200;}

        char c[] = s.toCharArray();
        int count = 0;

        for(;count <= s.length() - 1; count++){
            if(c[count]=='M') sum += 1000;
            if(c[count]=='D') sum += 500;
            if(c[count]=='C') sum += 100;
            if(c[count]=='L') sum += 50;
            if(c[count]=='X') sum += 10;
            if(c[count]=='V') sum += 5;
            if(c[count]=='I') sum += 1;
        }
        return sum;
    }*/

    public int romanToInt(String s){
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            //从后向前遍历, 假如前一个数反而是更小的, 则此数变为相减
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}