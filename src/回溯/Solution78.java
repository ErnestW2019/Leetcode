package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
78. 子集
难度
中等

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class Solution78 {
	/*******回溯法***************/
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) { 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums,0,res);
        return res;
    }
    public void dfs(int[] nums,int start,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i+1,res);
            list.remove(list.size()-1);
        }
    }
    /***************循环法 每次去取然后加上新的数**********/
    public List<List<Integer>> subsets2(int[] nums) { 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for(int num:nums){
            int size = res.size();
            for(int i=0;i<size;i++){
                list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}
