package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution47 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int visited[] = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
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
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==0) continue;
            list.add(nums[i]);
            visited[i] = 1;
            dfs(nums,list,visited);
            visited[i] = 0;
            list.remove(list.size()-1);
            
        }
    }
}
