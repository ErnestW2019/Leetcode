package 堆;

import java.util.HashMap;

/*
 * 659. 分割数组为连续子序列
难度
中等
给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
如果可以完成上述分割，则返回 true ；否则，返回 false 。
 
示例 1：
输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5
 
示例 2：
输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5
 
示例 3：
输入: [1,2,3,4,4,5]
输出: False
 
提示：
输入的数组长度范围为 [1, 10000]
 */
public class Solution659 {
	public boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> count =  new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> tails =  new HashMap<Integer,Integer>();
		for(int x:nums) {
			count.put(x, count.getOrDefault(x, 0)+1);
		}
		for(int x:nums) {
			if(count.get(x)==0) {
				continue;
			}else if(tails.get(x)>0) {
				tails.put(x,tails.get(x)-1);
				tails.put(x+1,tails.get(x+1)+1);
				
			}else if(count.get(x+1)>0&&count.get(x+2)>0) {
				count.put(x+1, count.get(x+1)-1);
				count.put(x+2, count.get(x+2)-1);
				tails.put(x+3,tails.get(x+3)+1);
				
			}else {
				return false;
			}
			count.put(x, count.get(x)-1);
		}
		return true;
	}
}
