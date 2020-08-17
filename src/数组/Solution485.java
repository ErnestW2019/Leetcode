package 数组;

public class Solution485 {
	/*********常规思路，一遍遍历*************/ //2ms,41.5MB
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0,res = 0;
        for(int num:nums){
            if(num==1) count++;
            else{
                res = Math.max(res,count);
                count=0;
            }
        }
        res = Math.max(res,count);
        return res;
    }
    /***********滑动窗口**************/
    public static int findMaxConsecutiveOnes2(int[] nums) {
    	int i=0,j=0;
    	int max=0;
    	while(j<nums.length) {
    		if(nums[j]==1) {
    			j++;
    			max = Math.max(j-i, max);
    		}else {
    			j++;
    			i = j;
    		}
    	}
    	return max;
    }
    public static void main(String[] args) {
    	int nums[] = new int[] {1,1,0,1,0,1,1};
    	System.out.println(findMaxConsecutiveOnes2(nums));
    }
}
