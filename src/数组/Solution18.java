package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 18. 四数之和
难度
中等
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) continue;
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) continue;
                if(nums[i]+nums[j]+nums[len-1]+nums[len-2]<target) continue;
                int k=j+1,l=nums.length-1;
                while(k<l){
                    int sum = nums[i]+nums[j]+nums[l]+nums[k];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k<l&&nums[k]==nums[k+1]){
                            k++;
                        }
                        while(l>k&&nums[l]==nums[l-1]){
                            l--;
                        }
                        l--;
                        k++;
                    }else if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }
                }
            } 
        }
        return res;
    }
}
