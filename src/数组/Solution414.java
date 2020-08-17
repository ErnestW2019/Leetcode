package 数组;
/*
 * 414. 第三大的数
难度
简单
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
示例 1:
输入: [3, 2, 1]

输出: 1

解释: 第三大的数是 1.
示例 2:
输入: [1, 2]

输出: 2

解释: 第三大的数不存在, 所以返回最大的数 2 .
示例 3:
输入: [2, 2, 3, 1]

输出: 1

解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
 */
public class Solution414 {
	/******************三次循环*******************/
    public int thirdMax(int[] nums) {
        //int i=0,j=1,k=2;
        int max1 = nums[0];
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int num:nums){
            if(max1<num){
                max1 = num;
            }
        }
        for(int num:nums){
            if(max2<num&&num<max1){
                max2 = num;
            }
        }
        boolean flag = false;
        for(int num:nums){
            
            if(num>=max3&&(num<max1&&num<max2)){
                max3 = num;
                flag = true;
            }
            


        }
        if(!flag) return max1; 
        return max3;

    }
    /******************一次循环*******************/
    public int thirdMax2(int[] nums) {
        int max1 = nums[0];
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]>max1) {
    			max3 = max2;
    			max2 = max1;
    			max1 = nums[i];
    		}else if(nums[i]>max2&&nums[i]<max1) {
    			max3 = max2;
    			max2 = nums[i];
    		}else if(nums[i]>max3&&nums[i]<max2) {
    			max3 = nums[i];
    		}
    	}
    	return max3==Long.MIN_VALUE?max1:(int)max3;
    }
    
}
