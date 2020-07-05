//A character in UTF8 can be from 1 to 4 bytes long, subjected to the following 
//rules: 
// 
// For 1-byte character, the first bit is a 0, followed by its unicode code. 
// For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, foll
//owed by n-1 bytes with most significant 2 bits being 10. 
// 
// This is how the UTF-8 encoding would work: 
//
//    Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// 
// 
//Given an array of integers representing the data, return whether it is a valid
// utf-8 encoding.
// 
// 
//Note: 
//The input is an array of integers. Only the least significant 8 bits of each i
//nteger is used to store the data. This means each integer represents only 1 byte
// of data.
// 
//
// 
//Example 1:
// 
//data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 0
//0000001.
//
//Return true.
//It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte char
//acter.
// 
// 
//
// 
//Example 2:
// 
//data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 
//00000100.
//
//Return false.
//The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes char
//acter.
//The next byte is a continuation byte which starts with 10 and that's correct.
//But the second continuation byte does not start with 10, so it is invalid.
// 
// Related Topics Bit Manipulation 
// 👍 215 👎 1012


package com.leetcode.editor.en;

public class Utf8Validation{
    public static void main(String[] args) {
       Solution solution = new Utf8Validation().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //利用mask检验第几位为1
    /*public boolean validUtf8(int[] data) {
        int i = 0;
        boolean curCheckValid = true;
        while (i < data.length) {
            int curByte = data[i];
            int mask = 1 << 7; // 10000000
            if((mask & curByte) == 0) { //第一位非1, 是ASCII, 跳过无需验证
                i++;
            } else{
                int n = getSize(data[i]);
                curCheckValid = checkNByte(data, i, n);
                i += n;
            }

            if(!curCheckValid){
                return false;
            }
        }
        return true;
    }

    private boolean checkNByte(int[] data, int i, int n){
        //检测获取size长度是否满足要求
        if(n <= 1){
            return false;
        }
        //检测data数组是否满足长度要求
        if(i + n > data.length){
            return false;
        }
        //检测data数组是否满足UTF-8定义要求
        int mask1 = 1 << 7; // 10000000 & output != 0 has 1
        int mask0 = 1 << 6; // 01000000 & output == 0 has 0
        for(int j = i + 1; j < i + n; j++){
            if((mask1 & data[j]) == 0 || (mask0 & data[j]) != 0){
                return false;
            }
        }
        return true;
    }

    private int getSize(int curByte){
        int size = 0;
        int i = 0;
        int mask = 1 << 7;
        while (i < 4) {
            if((mask & curByte) != 0){
                size++;
                i++;
                mask = mask >> 1;
            } else {
                break;
            }
        }
        // 假如非break退出, 检测第5位是否为1, 是的话不满足UTF-8要求
        if((mask & curByte) != 0) {
            return -1;
        }
        return size;
    }*/


    public boolean validUtf8(int[] data){
        int cnt = 0;
        for(int d : data){
            if(cnt == 0){
                if((d >> 5) == 0b110) {
                    cnt = 1;
                } else if((d >> 4) == 0b1110) {
                    cnt = 2;
                } else if((d >> 3) == 0b11110) {
                    cnt = 3;
                } else if((d >> 7) == 1) {
                    return false;
                }
            } else {
                if((d >> 6) != 0b10) {
                    return false;
                } else {
                    cnt--;
                }
            }
        }
        return cnt == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}