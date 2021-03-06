package 排序;

import java.util.Arrays;

/*
 * 56. 合并区间
难度
中等

给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        int idx = -1;
        int [][] res = new int[intervals.length][2];
        for(int[] interval : intervals){
            if(idx == -1||interval[0]>res[idx][1]){
                res[++idx] = interval;
            }else{
                res[idx][1] = Math.max(interval[1],res[idx][1]);
            }
        }
        return Arrays.copyOf(res,idx+1); //复制一个新的数组，长度为idx+1
    }
}
