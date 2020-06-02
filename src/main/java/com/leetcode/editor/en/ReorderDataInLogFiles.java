//You have an array of logs. Each log is a space delimited string of words. 
//
// For each log, the first word in each log is an alphanumeric identifier. Then,
// either: 
//
// 
// Each word after the identifier will consist only of lowercase letters, or; 
// Each word after the identifier will consist only of digits. 
// 
//
// We will call these two varieties of logs letter-logs and digit-logs. It is gu
//aranteed that each log has at least one word after its identifier. 
//
// Reorder the logs so that all of the letter-logs come before any digit-log. Th
//e letter-logs are ordered lexicographically ignoring identifier, with the identi
//fier used in case of ties. The digit-logs should be put in their original order.
// 
//
// Return the final order of the logs. 
//
// 
// Example 1: 
// Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","l
//et3 art zero"]
//Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig
//2 3 6"]
// 
// 
// Constraints: 
//
// 
// 0 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] is guaranteed to have an identifier, and a word after the identifier.
// 
// 
// Related Topics String


package com.leetcode.editor.en;

import java.util.Arrays;

public class ReorderDataInLogFiles{
    public static void main(String[] args) {
       Solution solution = new ReorderDataInLogFiles().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //重写排序算法
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int comp = split1[1].compareTo(split2[1]);
                if(comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            }
            else if(isDigit1 && isDigit2){
                return 0;
            }
            else if(isDigit1 && !isDigit2){
                return 1;
            }
            else {
                return -1;
            }
        });
        return logs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}