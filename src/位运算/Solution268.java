package 位运算;
/*
 * 268. 缺失数字
难度
简单

给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
示例 1:
输入: [3,0,1]
输出: 2
示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        //求和法
        int sum = 0;
        int n = nums.length;
        for(int num:nums){
            sum += num;
        }
        return (n*(n+1))/2 - sum;
    }
    public int missingNumber2(int[] nums) {
	    //异或法，利用下标充当出现第二次的数，由于数组中缺少0-n中某一个数，那么结合下标，他只出现一次
	    int missing = nums.length;
	    for(int i=0;i<nums.length;i++){
	        missing ^= nums[i]^i;
	    }
	    return missing;
    }
}
