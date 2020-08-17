package 数组;
/*
 * 16. 最接近的三数之和
难度
中等

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 
示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 
提示：
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */
import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int L=i+1,R=nums.length-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(Math.abs(sum-target)<=diff){
                    diff = Math.abs(sum-target);
                    res = sum;
                }
                if(sum-target<0){
                    L++;
                }else if(sum-target>0){
                    R--;
                }else{
                    return sum;
                }
            }
        }
        return res;
    }
}
