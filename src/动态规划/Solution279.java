package 动态规划;

import java.util.Arrays;

/*
 * 279. 完全平方数
难度
中等

给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
示例 1:
输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */
public class Solution279 {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int k=1,j=1;j<=i;++k,j = k*k){
                dp[i] = Math.min(dp[i-j]+1,dp[i]);
            }
        }
        return dp[n];
    }
}
