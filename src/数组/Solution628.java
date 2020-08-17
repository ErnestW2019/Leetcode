package 数组;
/*
 * 628. 三个数的最大乘积
难度
简单

给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
示例 1:
输入: [1,2,3]
输出: 6
示例 2:
输入: [1,2,3,4]
输出: 24
注意:
给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        //找到三个最大值或者两个小于0的最小值以及一个最大值
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i]>max3){
                max3 = nums[i];
            }
            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i]<min2){
                min2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);

    }
    /*
    //方法二：直接排序
    Arrays.sort(nums);
    return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);
    */
}
