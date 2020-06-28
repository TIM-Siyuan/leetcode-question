//Given a date, return the corresponding day of the week for that date. 
//
// The input is given as three integers representing the day, month and year res
//pectively. 
//
// Return the answer as one of the following values {"Sunday", "Monday", "Tuesda
//y", "Wednesday", "Thursday", "Friday", "Saturday"}. 
//
// 
// Example 1: 
//
// 
//Input: day = 31, month = 8, year = 2019
//Output: "Saturday"
// 
//
// Example 2: 
//
// 
//Input: day = 18, month = 7, year = 1999
//Output: "Sunday"
// 
//
// Example 3: 
//
// 
//Input: day = 15, month = 8, year = 1993
//Output: "Sunday"
// 
//
// 
// Constraints: 
//
// 
// The given dates are valid dates between the years 1971 and 2100. 
// Related Topics Array


package com.leetcode.editor.en;

public class DayOfTheWeek{
    public static void main(String[] args) {
       Solution solution = new DayOfTheWeek().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String dayOfTheWeek(int day, int month, int year) {
        if(month < 3){
            month += 12;
            year -= 1;
        }
        int c = year / 100;
        year = year % 100;
        int w = (c / 4 - 2 * c + year + year / 4 + 13 * (month + 1) / 5 + day - 1) % 7;
        return days[(w + 7) % 7];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}