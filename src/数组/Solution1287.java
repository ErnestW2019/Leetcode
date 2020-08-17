package 数组;
/*
 * 1287. 有序数组中出现次数超过25%的元素
难度
简单

给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
请你找到并返回这个整数
 
示例：
输入：arr = [1,2,2,6,6,6,6,7,10]
输出：6
 
提示：
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
 */
public class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        /*********************暴力法**********************/
        int temp = arr[0],cnt = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==temp){
                cnt++;
                if(4*cnt>arr.length){
                    return arr[i];
                }
            }else{
                temp = arr[i];
                cnt = 1;
            }
        }
        return arr[0];

    }
}
