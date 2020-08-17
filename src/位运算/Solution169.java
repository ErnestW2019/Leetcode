package 位运算;

import java.util.Arrays;

/*
 * 169. 多数元素
难度
简单

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class Solution169 {
	/*******API法***********************/
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
	/*************摩尔投票法*******************/
    public int majorityElement(int[] nums) {
    	int maj = nums[0];
    	int count = 1;
    	for(int i=1;i<nums.length;i++) {
    		if(count==0) {
    			maj = nums[i];
    			count = 1;
    		}
    		else{
    			if(maj == nums[i]) {
        			count++;
        		}else {
        			count--;
        		}
    		}

    	}
    	return maj;
    }
}
