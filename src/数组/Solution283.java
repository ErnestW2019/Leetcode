package 数组;

import java.util.Arrays;

public class Solution283 {
	/*************双指针法****************///0ms
    public void moveZeroes(int[] nums) {
        for(int i=0,j=0;i<nums.length&&j<nums.length;j++){
            if(nums[j]!=0){
                int tem = nums[j];
                nums[j] = nums[i];
                nums[i] = tem;
                i++;
            }
        }
    }
    /***************直接交换，最后补0****************************************/ //0ms
    public void moveZeroes2(int[] nums) {
    	int i=0,j=0;
    	for(;j<nums.length;j++) {
    		if(nums[j]!=0) {
    			nums[i++] = nums[j]; 
    		}
    	}
    	while(i!=nums.length) {
    		nums[i++]=0;
    	}
    }
    public static void main(String[] args) {
    	int [] nums = new int[] {0,0,0,0,0};
    	Solution283 solution283 = new Solution283();
    	solution283.moveZeroes2(nums);
    	
    	System.out.println(Arrays.toString(nums));
    }
}
