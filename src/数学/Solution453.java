package 数学;


/*
 * 453. 最小移动次数使数组元素相等
难度
简单

给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 
示例:
输入:
[1,2,3]

输出:
3

解释:
只需要3次移动（注意每次移动会增加两个元素的值）：

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Solution453 {
	/************数学法，推公式*************/
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
            sum += nums[i];
        }
        return sum-min*nums.length;

    }
    
	/************改进数学法*************/
   //避免整数和过大溢出
    public int minMoves2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int move = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
            
        }
        for(int i=0;i<nums.length;i++) {
        	move += nums[i] - min;
        }
        return move;

    }
}
