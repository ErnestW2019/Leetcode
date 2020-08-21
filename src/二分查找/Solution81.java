package 二分查找;

import java.util.Arrays;

public class Solution81 {
    public static boolean search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l<=r){
            while(l<r&&nums[l]==nums[l+1]) l++;  //先去重 保证前后无重复
            while(l<r&&nums[r]==nums[r-1]) r--;
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>=nums[l]){
                if(nums[mid]>target&&target>=nums[l]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else if(nums[mid]<=nums[r]){
                if(nums[mid]<target&&target<=nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
    	int nums[] = new int[]{2,5,6,0,0,1,2};
    	int target = 3;
    	System.out.println(search(nums,target));
    }
}
