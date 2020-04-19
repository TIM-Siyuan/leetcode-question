//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String letterMap[] = {
        " ",   //0
        "",    //1
        "abc", //2
        "def", //3
        "ghi", //4
        "jkl", //5
        "mno", //6
        "pqrs", //7
        "tuv", //8
        "wxyz" //9
    };
    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if(digits.equals("")) return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){
//        System.out.println(index + " : " + s);
        if(index == digits.length()){
            res.add(s);
            return;
        }

        char c = digits.toCharArray()[index];
        assert (c >= '0' && c <= '9' && c != '1');
        String letters = letterMap[c - '0'];
        for(int i = 0; i < letters.length(); i++){
//          System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

//      System.out.println("digits[" + index + "] = " + c + " complete, return");
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}