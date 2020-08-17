package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. 括号生成
难度
中等

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(list,sb,0,0,n);
        return list;
    }
    private void dfs(List<String> list,StringBuilder sb,int left,int right,int n){
        if(left==n&&right==n){
            list.add(sb.toString());
            return;
        }
        if(left<right) return;
        if(left<n){
            sb.append("(");
            dfs(list,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<n){
            sb.append(")");
            dfs(list,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
