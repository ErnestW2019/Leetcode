package 数组;
/*
 * 581. 最短无序连续子数组
难度
简单

给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。
示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :
输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        //从左到右遍历，最后一个破坏递增的数为右边界
        //定义标记为，保证遇到的是第一个
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max){
                right = i;
            }
            max = Math.max(nums[i],max);
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>min){
                left = i;
            }
            min = Math.min(nums[i],min);
        }
        return right==left?0:right-left+1;
    }
	public static void main(String[] args) {
		int nums [] = new int[] {3,2,3,2,4};
		System.out.println(findUnsortedSubarray(nums));
	}
}
