package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 39. 组合总和
难度
中等

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 
提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */
public class Solution39 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        backtrack(candidates,list,target,0);
        return ans;
    }
    private void backtrack(int[] candidates,List<Integer> list,int target,int start){
        if(target<0) return;
        if(target==0) ans.add(new ArrayList<>(list));
        else{
            for(int i=start;i<candidates.length;i++){
                list.add(candidates[i]);
                backtrack(candidates,list,target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }
}
