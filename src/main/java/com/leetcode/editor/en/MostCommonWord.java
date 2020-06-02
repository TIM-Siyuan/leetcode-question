//Given a paragraph and a list of banned words, return the most frequent word th
//at is not in the list of banned words. It is guaranteed there is at least one wo
//rd that isn't banned, and that the answer is unique. 
//
// Words in the list of banned words are given in lowercase, and free of punctua
//tion. Words in the paragraph are not case sensitive. The answer is in lowercase.
// 
//
// 
//
// Example: 
//
// 
//Input: 
//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//banned = ["hit"]
//Output: "ball"
//Explanation: 
//"hit" occurs 3 times, but it is a banned word.
//"ball" occurs twice (and no other word does), so it is the most frequent non-b
//anned word in the paragraph. 
//Note that words in the paragraph are not case sensitive,
//that punctuation is ignored (even if adjacent to words, such as "ball,"), 
//and that "hit" isn't the answer even though it occurs more because it is banne
//d.
// 
//
// 
//
// Note: 
//
// 
// 1 <= paragraph.length <= 1000. 
// 0 <= banned.length <= 100. 
// 1 <= banned[i].length <= 10. 
// The answer is unique, and written in lowercase (even if its occurrences in pa
//ragraph may have uppercase symbols, and even if it is a proper noun.) 
// paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
// 
// There are no hyphens or hyphenated words. 
// Words only consist of letters, never apostrophes or other punctuation symbols
//. 
// 
// Related Topics String


package com.leetcode.editor.en;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord{
    public static void main(String[] args) {
       Solution solution = new MostCommonWord().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        // \\W means matches the nonword characters.
        String[] s1 = paragraph.toLowerCase().split("\\W+");
        for(String ban : banned){
            set.add(ban);
        }
        for(int i = 0; i < s1.length; i++){
            if(set.contains(s1[i])) continue;
            map.put(s1[i], map.getOrDefault(s1[i], 0) + 1);
        }
        int max = 0;
        String res = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}