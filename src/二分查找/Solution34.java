package 二分查找;
/*
 * 34. 在排序数组中查找元素的第一个和最后一个位置
难度
中等

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        if(nums.length==0) return new int[]{-1,-1};
        res[0] = binarySearchLeftBound(nums, target);
        res[1] = binarySearchRightBound(nums, target);
        return res;
    }

    public int binarySearchLeftBound(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }


    public int binarySearchRightBound(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(right>=0&&nums[right]==target){
            return right;
        }
        return -1;
    }
}
