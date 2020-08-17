package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * 697. 数组的度
难度
简单

给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
示例 1:
输入: [1, 2, 2, 3, 1]
输出: 2
解释: 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:
输入: [1,2,2,3,1,4,2]
输出: 6
注意:
nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。
 */
public class Solution697 {
	/**********hashmap法************************///21ms
    public static int findShortestSubArray(int[] nums) {
        int maxdegree = 0,num=Integer.MAX_VALUE;
        //先用map保存数和同一个数的索引list
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey((nums[i]))) {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
            }else {
            	map.get(nums[i]).add(i);
            }
        }
        //int degree = 0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
        	//maxdegree = Math.max(maxdegree, entry.getValue().size());
        	if(entry.getValue().size()>maxdegree) {
        		maxdegree = entry.getValue().size();
        		num = Integer.MAX_VALUE;
        		num = Math.min(num, entry.getValue().get(entry.getValue().size()-1)-entry.getValue().get(0)+1);
        	}else if(entry.getValue().size()==maxdegree) {
        		num = Math.min(num, entry.getValue().get(entry.getValue().size()-1)-entry.getValue().get(0)+1);
        	}
        }
        return num;
    }
    public static void main(String[] args) {
    	int nums[] = new int[] {1,2,2,3,1};
    	System.out.println(findShortestSubArray(nums));
    }
}
