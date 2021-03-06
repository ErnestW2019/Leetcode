package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 40. 组合总和 II
难度
中等

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class Solution40 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,list,target,0);
        return ans;
    }
    private void backtrack(int[] candidates,List<Integer> list,int target,int start){
        if(target<0) return;
        if(target==0) ans.add(new ArrayList<>(list));
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start&&candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                backtrack(candidates,list,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
