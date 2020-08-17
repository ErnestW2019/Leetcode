package 数组;
/*
 * 31. 下一个排列
难度
中等
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

158476531 -> 158513467
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=i+1;
            while(j<=nums.length-1&&nums[j]>nums[i]){
                j++;
            }
            swap(nums,i,j-1);
        }
        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums,int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
