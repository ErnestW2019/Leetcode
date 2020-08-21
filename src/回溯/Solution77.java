package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 77. 组合
难度
中等

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Solution77 {
	/*********回溯加剪枝*****************/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        dfs(n,k,list,res,1);
        return res;
    }
    public void dfs(int n,int k,List<Integer> list,List<List<Integer>> res,int start){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n-(k-list.size())+1;i++){  //剪枝
            list.add(i);
            dfs(n,k,list,res,i+1);
            list.remove(list.size()-1);
        }
    }
}
