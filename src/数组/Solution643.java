package 数组;


/*
 * 643. 子数组最大平均数 I
难度
简单

给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
示例 1:
输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 
注意:
1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
 */
public class Solution643 {
	/********重复计算，超时*****************/
    public static double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double sum=0;
        for(int i=0,j=k-1,m=0;i<=j&&j<nums.length;){
            sum += nums[i];
            if(i==j) {
                res = Math.max(sum/k,res);
                j++;
                m++;
                i=m;
                sum=0;
            }
            else{
                i++;
            }
        }
        return res;
    }
    /**************去重******************/
    public static double findMaxAverage2(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double sum=0;
        boolean flag = true;
        for(int i=0,j=0;j<nums.length;){

            if(flag) {
                sum += nums[j];
                j++;
            }
            else {
                sum = sum-nums[i-1]+nums[j];
                res = Math.max(sum/k,res);
                i++;
                j++;
            }
            if(j==k) {
                res = Math.max(sum/k,res);
                i++;
                flag = false;
            }
        }

        return res;
    }
    public static void main(String[] args) {
    	long Starttime=System.currentTimeMillis();
    	int [] nums = new int [] {1,12,-5,-6,50,3};
    	System.out.println(findMaxAverage2(nums,4));
    	long endtime=System.currentTimeMillis();
    	System.out.println((endtime-Starttime));
    }
}
