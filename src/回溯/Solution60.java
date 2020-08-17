package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 60. 第k个排列
难度
中等
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
示例 2:
输入: n = 4, k = 9
输出: "2314"
 */
public class Solution60 {

	/*************回溯提前break，时间仍然很长*********************/
    public static String getPermutation1(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int visit[] = new int[n+1];
        /*
        int num[] = new int[n];
        for(int i=1;i<=n;i++){
            num[i] = i;
        }*/
        dfs(sb,list,n,visit,k);
        return list.get(k-1);
    }
    public static void dfs(StringBuilder sb,List<String> list,int n,int[] visit,int k){
        if(sb.length()==n){
            list.add(new StringBuilder(sb).toString());
            return;
        }
        for(int i=1;i<=n;i++){
        	if(list.size()==k) break;
            if(visit[i]==1) continue;
            sb.append(i);
            visit[i] = 1;
            dfs(sb,list,n,visit,k);
            visit[i] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    /*********康托展开和逆康托展开***************/
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i=1;i<=n;i++){
            list.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k--;
        for(int i=n-1;i>=0;i--){
            int index = k/factorials[i];
            sb.append(list.remove(index));
            //k -= index*factorials[i];
            k = k%factorials[i];
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int n = 8;
    	int k=100;
    	System.out.println(getPermutation(n, k));
    }
}
