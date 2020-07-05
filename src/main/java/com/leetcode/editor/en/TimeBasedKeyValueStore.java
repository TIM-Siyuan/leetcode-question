//Create a timebased key-value store class TimeMap, that supports two operations
//. 
//
// 1. set(string key, string value, int timestamp) 
//
// 
// Stores the key and value, along with the given timestamp. 
// 
//
// 2. get(string key, int timestamp) 
//
// 
// Returns a value such that set(key, value, timestamp_prev) was called previous
//ly, with timestamp_prev <= timestamp. 
// If there are multiple such values, it returns the one with the largest timest
//amp_prev. 
// If there are no values, it returns the empty string (""). 
// 
//
// 
//
// 
// Example 1: 
//
// 
//Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],
//["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//Output: [null,null,"bar","bar",null,"bar2","bar2"]
//Explanation:   
//TimeMap kv;   
//kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with tim
//estamp = 1   
//kv.get("foo", 1);  // output "bar"   
//kv.get("foo", 3); // output "bar" since there is no value corresponding to foo
// at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar" 
//  
//kv.set("foo", "bar2", 4);   
//kv.get("foo", 4); // output "bar2"   
//kv.get("foo", 5); //output "bar2"   
//
// 
//
// 
// Example 2: 
//
// 
//Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs 
//= [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["
//love",20],["love",25]]
//Output: [null,null,null,"","high","high","low","low"]
// 
// 
// 
//
// 
//
// Note: 
//
// 
// All key/value strings are lowercase. 
// All key/value strings have length in the range [1, 100] 
// The timestamps for all TimeMap.set operations are strictly increasing. 
// 1 <= timestamp <= 10^7 
// TimeMap.set and TimeMap.get functions will be called a total of 120000 times 
//(combined) per test case. 
// 
// Related Topics Hash Table Binary Search 
// 👍 721 👎 87


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore{
    public static void main(String[] args) {
       //Solution solution = new TimeBasedKeyValueStore().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
    class Data{
        String val;
        int time;
        Data(String val, int time){
            this.val = val;
            this.time = time;
        }
    }

    /** Initialize your data structure here. */
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Data>());
        }
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        return binarySearch(map.get(key), timestamp);
    }

    String binarySearch(List<Data> list, int time){
        int low = 0, high = list.size() - 1;
        while (low < high){
            int mid = (low + high + 1) >> 1;
            if(list.get(mid).time <= time){
                low = mid;
            } else{
                high = mid - 1;
            }
        }
        return list.get(low).time <= time ? list.get(low).val : ""; // low == high
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)


}