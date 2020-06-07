//There are 8 prison cells in a row, and each cell is either occupied or vacant.
// 
//
// Each day, whether the cell is occupied or vacant changes according to the fol
//lowing rules: 
//
// 
// If a cell has two adjacent neighbors that are both occupied or both vacant, t
//hen the cell becomes occupied. 
// Otherwise, it becomes vacant. 
// 
//
// (Note that because the prison is a row, the first and the last cells in the r
//ow can't have two adjacent neighbors.) 
//
// We describe the current state of the prison in the following way: cells[i] ==
// 1 if the i-th cell is occupied, else cells[i] == 0. 
//
// Given the initial state of the prison, return the state of the prison after N
// days (and N such changes described above.) 
//
// 
//
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: cells = [0,1,0,1,1,0,0,1], N = 7
//Output: [0,0,1,1,0,0,0,0]
//Explanation: 
//The following table summarizes the state of the prison on each day:
//Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
// 
//
// 
// Example 2: 
//
// 
//Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
//Output: [0,0,1,1,1,1,1,0]
// 
//
// 
//
// Note: 
//
// 
// cells.length == 8 
// cells[i] is in {0, 1} 
// 1 <= N <= 10^9 
// 
// 
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

public class PrisonCellsAfterNDays{
    public static void main(String[] args) {
       Solution solution = new PrisonCellsAfterNDays().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //法一: 试验已得14为循环节数63
    /*public int[] prisonAfterNDays(int[] cells, int N) {
        //因为从1开始, 取模时先减再加
        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            cells = nextDay(cells);
        }
        return cells;
    }

    //法二: 需要找hasCycle
    public int[] prisonAfterNDays(int[] cells, int N) {
        //先判断是否存在Cycle mod14
        Map<String, Integer> map = new HashMap<>();
        while(N > 0){
            map.put(Arrays.toString(cells), N--);
            cells = nextDay(cells);
            //hasCycle
            if(map.containsKey(Arrays.toString(cells))){
                //(map.get(Arrays.toString(cells)) - N)得到循环节数, 经试验等于14
                N %= (map.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }

    public int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++){
            temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return temp;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}