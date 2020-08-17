package 面试;

public class Solution17_10 {
    /****************暴力法*******************/  //2194ms,43.1MB
    /*public int majorityElement(int[] nums) {
        
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]) cnt++;
                if(2*cnt>=nums.length){
                    return nums[i];
                }
            }
            cnt = 0;
        }
        return -1;
    }*/
    /****************暴力法改进*******************/  //2633ms,43.1MB
    /*public int majorityElement(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int dif = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]) cnt++;
                else dif++;
                if(2*cnt>=nums.length){
                    return nums[i];
                }
                if(2*dif>=nums.length){
                    break;
                }
            }
            cnt = 0;
            dif = 0;
        }
        return -1;
    }*/
    /***************摩尔投票法**********************/  //2ms,42.9MB
    /*public int majorityElement(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int major = 0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                major = nums[i];
                cnt++;
            }else{
                if(nums[i]!=major) cnt--;
                else cnt++;
            }
        }
        cnt = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==major) cnt++;
            if(cnt*2>=len){
                return major;
            }
        }
        return -1;
    }
    */
    /***************分治算法**********************/  //2ms,42.9MB
    public int majorityElement(int[] nums) {
		return 0;
        
    }
    private int divide(int[] nums,int left, int right){
		return right;

    }
}
