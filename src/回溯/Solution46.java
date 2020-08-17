package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 46. 全排列
难度
中等
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int visited[] = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,visited);
        return res;
    }
    private void dfs(int[] nums,List<Integer> list,int[] visited){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        } 
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1) continue;
            list.add(nums[i]);
            visited[i] = 1;
            dfs(nums,list,visited);
            visited[i] = 0;
            list.remove(list.size()-1);
            
        }
    }
}
