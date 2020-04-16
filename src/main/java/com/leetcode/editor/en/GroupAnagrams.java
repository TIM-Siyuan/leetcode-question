//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


package com.leetcode.editor.en;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
       String[] test = {"eat","tea","tan","ate","nat","bat"};
       solution.groupAnagrams(test);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }else{
                map.put(temp, new ArrayList<>());
                map.get(temp).add(strs[i]);
            }
        }

        for(List res : map.values()){
            list.add(res);
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}