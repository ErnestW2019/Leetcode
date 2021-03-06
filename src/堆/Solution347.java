package 堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.PriorityQueue;

/*
 * 347. 前 K 个高频元素
难度
中等

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]
 
提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(entry);
        }
        for(int i=0;i<k;i++){
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
