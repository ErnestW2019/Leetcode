package 二分查找;
/*
 * 面试题53 - I. 在排序数组中查找数字 I
难度
简单

统计一个数字在排序数组中出现的次数。
 
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 
限制：
0 <= 数组长度 <= 50000
 
 */
public class Solution53_1 {
    public int search(int[] nums, int target) {
        //if(nums.length==1) return nums[0]==target?1:0;
        int l=0,r=nums.length-1;
        //寻找左边界
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>=target){
                r = mid-1;
            }
        }
        int low=l;
        l=0;
        r=nums.length-1;
        //寻找右边界
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]<=target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }
        }
        int high=r+1;
        return high-low;
    }
}
