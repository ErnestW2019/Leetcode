package 面试;

public class Solution16_17 {
    // 分治法
    static int maxSubArray(int[] nums)
    {
        if(nums.length == 0) return Integer.MIN_VALUE;
        return divide(nums,0,nums.length-1);
    }
    static int divide(int[] nums, int left, int right)
    {
        if(left == right) {
        	return nums[left];
        }
        int mid = (left + right) / 2;
        // 1. 最大数列和在左边
        int sumLeft = divide(nums,left,mid);
        // 2. 最大数列和在右边
        int sumRight = divide(nums,mid+1,right);
        // 3. 最大数列和在中间
        // 先求左边的最大和
        int leftSum = 0,leftMaxSum = Integer.MIN_VALUE;
        for(int i = mid; i >= left; i--)
        {
            leftSum += nums[i];
            leftMaxSum = Math.max(leftMaxSum,leftSum);
        }
        // 求右边的最大和
        int rightSum = 0,rightMaxSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= right; i++)
        {
            rightSum += nums[i];
            rightMaxSum = Math.max(rightMaxSum,rightSum);
        }
        return Math.max(Math.max(sumLeft,sumRight),leftMaxSum+rightMaxSum);
    }
    public static void main(String[] args) {
    	int nums[] = new int [] {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(maxSubArray(nums));
    }

}
